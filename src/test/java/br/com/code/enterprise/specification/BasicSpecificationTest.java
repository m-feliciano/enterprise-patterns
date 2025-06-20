package br.com.code.enterprise.specification;

import br.com.code.enterprise.specification.internal.specs.CreatedAfterDateSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceGreaterThanSpecification;
import br.com.code.enterprise.specification.internal.specs.PriceLessThanSpecification;
import br.com.code.enterprise.specification.model.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicSpecificationTest extends BaseSpecificationTest {

    @Test
    @DisplayName("Deve retornar entidades com preço maior que 100")
    public void testPriceGreaterThanSpecification() {
        // Given
        Specification<Entity> specification = new PriceGreaterThanSpecification<>(100.0);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity ->
                assertTrue(entity.getPrice().doubleValue() > 100,
                        "Todas as entidades devem ter preço maior que 100")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades com preço menor que 100")
    public void testPriceLessThanSpecification() {
        // Given
        Specification<Entity> specification = new PriceLessThanSpecification<>(100.0);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity ->
                assertTrue(entity.getPrice().doubleValue() < 100,
                        "Todas as entidades devem ter preço menor que 100")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades criadas após uma data específica")
    public void testCreatedAfterDateSpecification() {
        // Given
        Specification<Entity> specification = new CreatedAfterDateSpecification<>(referenceDate);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity ->
                assertTrue(entity.getCreated().after(referenceDate),
                        "Todas as entidades devem ter sido criadas após a data de referência")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades com preço maior que 100 e criadas após uma data específica")
    public void testPriceGreaterThanAndCreatedAfterDateSpecification() {
        // Given
        CreatedAfterDateSpecification<Entity> createdSpec = new CreatedAfterDateSpecification<>(referenceDate);
        Specification<Entity> proceSpec = new PriceGreaterThanSpecification<>(100.0);
        Specification<Entity> specification = proceSpec.and(createdSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            assertTrue(entity.getPrice().doubleValue() > 100, "Todas as entidades devem ter preço maior que 100");
            assertTrue(entity.getCreated().after(referenceDate),
                    "Todas as entidades devem ter sido criadas após a data de referência");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com preço menor que 100 ou criadas após uma data específica")
    public void testPriceLessThanOrCreatedAfterDateSpecification() {
        // Given
        Specification<Entity> priceSpec = new PriceLessThanSpecification<>(100.0);
        CreatedAfterDateSpecification<Entity> createdSpec = new CreatedAfterDateSpecification<>(referenceDate);
        Specification<Entity> specification = priceSpec.or(createdSpec);
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity ->
                assertTrue(entity.getPrice().doubleValue() < 100 || entity.getCreated().after(referenceDate),
                        "Todas as entidades devem ter preço menor que 100 ou ter sido criadas após a data de referência")
        );
    }

    @Test
    @DisplayName("Deve retornar entidades com preço maior que 100 e não criadas após uma data específica")
    public void testPriceGreaterThanAndNotCreatedAfterDateSpecification() {
        // Given
        Specification<Entity> priceSpec = new PriceGreaterThanSpecification<>(100.0);
        Specification<Entity> dateSpec = new CreatedAfterDateSpecification<>(referenceDate);
        Specification<Entity> specification = priceSpec.and(dateSpec.not());
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertTrue(entity.getPrice().doubleValue() > 100,
                    "Todas as entidades devem ter preço maior que 100");
            assertFalse(entity.getCreated().after(referenceDate),
                    "Nenhuma entidade deve ter sido criada após a data de referência");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com preço menor que 100 e não criadas após uma data específica")
    public void testPriceLessThanAndNotCreatedAfterDateSpecification() {
        // Given
        Specification<Entity> priceSpec = new PriceLessThanSpecification<>(100.0);
        Specification<Entity> dateSpec = new CreatedAfterDateSpecification<>(referenceDate);
        Specification<Entity> specification = priceSpec.and(dateSpec.not());
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        result.forEach(entity -> {
            assertTrue(entity.getPrice().doubleValue() < 100, "Todas as entidades devem ter preço menor que 100");
            assertFalse(entity.getCreated().after(referenceDate), "Nenhuma entidade deve ter sido criada após a data de referência");
        });
    }
}
