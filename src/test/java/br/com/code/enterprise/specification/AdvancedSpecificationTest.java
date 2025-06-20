package br.com.code.enterprise.specification;

import br.com.code.enterprise.specification.internal.specs.ActiveSpecification;
import br.com.code.enterprise.specification.internal.specs.CreatedBeforeDateSpecification;
import br.com.code.enterprise.specification.internal.specs.IdRangeSpecification;
import br.com.code.enterprise.specification.internal.specs.InactiveSpecification;
import br.com.code.enterprise.specification.internal.specs.NameContainsSpecification;
import br.com.code.enterprise.specification.internal.specs.NameIgnoreCaseSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceBetweenSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceGreaterThanSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceLessThanSpecification;
import br.com.code.enterprise.specification.model.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedSpecificationTest extends BaseSpecificationTest {

    @Test
    @DisplayName("Deve retornar entidades ativas com preço menor que 200")
    public void testActiveEntitiesWithPriceLessThan() {
        // Given
        ActiveSpecification<Entity> activeSpec = new ActiveSpecification<>();
        PriceLessThanSpecification<Entity> priceSpec = new PriceLessThanSpecification<>(200.0);
        Specification<Entity> specification = activeSpec.and(priceSpec);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertTrue(entity.isActive(), "Todas as entidades devem estar ativas");
            assertTrue(entity.getPrice().doubleValue() < 200.0, "Todas as entidades devem ter preço menor que 200");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com ID entre 5 e 15 e nome não contendo '1'")
    public void testIdBetweenAndNameNotContaining() {
        // Given
        IdRangeSpecification<Entity> idRangeSpec = new IdRangeSpecification<>(5L, 15L);
        NameContainsSpecification<Entity> nameContainsSpec = new NameContainsSpecification<>("1");
        Specification<Entity> nameNotContains1 = nameContainsSpec.not();
        Specification<Entity> specification = idRangeSpec.and(nameNotContains1);


        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertTrue(entity.getId() >= 5 && entity.getId() <= 15, "Todas as entidades devem ter ID entre 5 e 15");
            assertFalse(entity.getName().contains("1"), "Nenhuma entidade deve ter nome contendo '1'");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com nome igual a 'Entity 10' ignorando case")
    public void testNameEqualsIgnoreCase() {
        // Given
        NameIgnoreCaseSpecification<Entity> specification = new NameIgnoreCaseSpecification<>("entity 10");

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertEquals(1, result.size(), "Deve retornar exatamente uma entidade");
        result.forEach(entity ->
                assertTrue(entity.getName().equalsIgnoreCase("entity 10"),
                        "O nome da entidade deve ser igual a 'entity 10' (ignorando case)")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades criadas antes de uma data específica ou com preço maior que 400")
    public void testCreatedBeforeDateOrPriceGreaterThan() {
        // Given
        CreatedBeforeDateSpecification<Entity> dateSpec = new CreatedBeforeDateSpecification<>(referenceDate);
        PriceGreaterThanSpecification<Entity> priceSpec = new PriceGreaterThanSpecification<>(400.0);
        Specification<Entity> specification = dateSpec.or(priceSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity ->
                assertTrue(entity.getCreated().before(referenceDate) || entity.getPrice().doubleValue() > 400.0,
                        "Todas as entidades devem ter sido criadas antes da data de referência ou ter preço maior que 400")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades ativas com preço entre 100 e 300, ou inativas com ID menor que 10")
    public void testComplexCombination() {
        // Given
        // Primeira parte: entidades ativas com preço entre 100 e 300
        ActiveSpecification<Entity> activeSpec = new ActiveSpecification<>();
        PriceBetweenSpecification<Entity> priceBetweenSpec = new PriceBetweenSpecification<>(100.0, 300.0);
        Specification<Entity> activePriceBetween = activeSpec.and(priceBetweenSpec);

        // Segunda parte: entidades inativas com ID < 10
        InactiveSpecification<Entity> inactiveSpec = new InactiveSpecification<>();
        IdRangeSpecification<Entity> idRangeSpec = new IdRangeSpecification<>(0L, 10L);
        Specification<Entity> inactiveIdLessThan10 = inactiveSpec.and(idRangeSpec);

        // Combinando as duas partes com OR
        Specification<Entity> specification = activePriceBetween.or(inactiveIdLessThan10);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            boolean condition1 = entity.isActive() &&
                                 entity.getPrice().doubleValue() >= 100.0 &&
                                 entity.getPrice().doubleValue() <= 300.0;
            boolean condition2 = !entity.isActive() && entity.getId() < 10;

            boolean any = condition1 || condition2;
            assertTrue(any, "Todas as entidades devem satisfazer uma das condições compostas");
        });
    }
}
