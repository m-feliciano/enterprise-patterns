package br.com.code.enterprise.specification;

import br.com.code.enterprise.specification.internal.specs.ActiveSpecification;
import br.com.code.enterprise.specification.internal.specs.CreatedBeforeDateSpecification;
import br.com.code.enterprise.specification.internal.specs.IdInCollectionSpecification;
import br.com.code.enterprise.specification.internal.specs.IdRangeSpecification;
import br.com.code.enterprise.specification.internal.specs.InactiveSpecification;
import br.com.code.enterprise.specification.internal.specs.NameContainsSpecification;
import br.com.code.enterprise.specification.internal.specs.NameStartsWithSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceBetweenSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceGreaterThanSpecification;
import br.com.code.enterprise.specification.model.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombinedSpecificationTest extends BaseSpecificationTest {

    @Test
    @DisplayName("Deve retornar entidades com nome contendo 'Entity' e preço entre 50 e 500")
    public void testNameContainsAndPriceBetweenSpecification() {
        // Given
        PriceBetweenSpecification<Entity> other = new PriceBetweenSpecification<>(50.0, 500.0);
        NameContainsSpecification<Entity> nameSpec = new NameContainsSpecification<>("Entity");
        Specification<Entity> specification = nameSpec.and(other);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            assertTrue(entity.getName().contains("Entity"),
                    "Todas as entidades devem ter nome contendo 'Entity'");
            double price = entity.getPrice().doubleValue();
            assertTrue(price >= 50.0 && price <= 500.0,
                    "Todas as entidades devem ter preço entre 50 e 500");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades inativas com ID maior que 10")
    public void testInactiveAndIdGreaterThanSpecification() {
        // Given
        InactiveSpecification<Entity> inactiveSpec = new InactiveSpecification<>();
        IdRangeSpecification<Entity> idRangeSpec = new IdRangeSpecification<>(10L, Long.MAX_VALUE);
        Specification<Entity> specification = inactiveSpec.and(idRangeSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertFalse(entity.isActive(), "Todas as entidades devem estar inativas");
            assertTrue(entity.getId() > 10, "Todas as entidades devem ter ID maior que 10");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com nome começando com 'Entity' e criadas antes de uma data específica")
    public void testNameStartsWithAndCreatedBeforeDateSpecification() {
        // Given
        NameStartsWithSpecification<Entity> nameSpec = new NameStartsWithSpecification<>("Entity");
        CreatedBeforeDateSpecification<Entity> dateSpec = new CreatedBeforeDateSpecification<>(referenceDate);
        Specification<Entity> specification = nameSpec.and(dateSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertTrue(entity.getName().startsWith("Entity"), "Todas as entidades devem ter nome começando com 'Entity'");
            assertTrue(entity.getCreated().before(referenceDate), "Todas as entidades devem ter sido criadas antes da data de referência");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com ID na coleção (1, 3, 5, 7)")
    public void testIdInCollectionSpecification() {
        // Given
        List<Long> allowedIds = Arrays.asList(1L, 3L, 5L, 7L);
        Specification<Entity> specification = new IdInCollectionSpecification<>(allowedIds);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertEquals(allowedIds.size(), result.size(), "Deve retornar exatamente o número de IDs permitidos");
        result.forEach(entity ->
                assertTrue(allowedIds.contains(entity.getId()), "O ID da entidade deve estar na lista de IDs permitidos")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades ativas ou com preço maior que 300")
    public void testActiveOrPriceGreaterThanSpecification() {
        // Given
        ActiveSpecification<Entity> activeSpec = new ActiveSpecification<>();
        PriceGreaterThanSpecification<Entity> priceSpec = new PriceGreaterThanSpecification<>(300.0);
        Specification<Entity> specification = activeSpec.or(priceSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity ->
                assertTrue(entity.isActive() || entity.getPrice().doubleValue() > 300.0,
                        "Todas as entidades devem estar ativas ou ter preço maior que 300")
        );
    }
}
