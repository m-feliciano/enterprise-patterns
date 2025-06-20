package br.com.code.enterprise.specification;

import br.com.code.enterprise.specification.internal.specs.CreatedBetweenDatesSpecification;
import br.com.code.enterprise.specification.internal.specs.CustomSpecification;
import br.com.code.enterprise.specification.internal.specs.NameEndsWithSpecification;
import br.com.code.enterprise.specification.internal.specs.NameInCollectionSpecification;
import br.com.code.enterprise.specification.internal.specs.NameLengthSpecification;
import br.com.code.enterprise.specification.internal.specs.NameMatchesRegexSpecification;
import br.com.code.enterprise.specification.model.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComplexSpecificationTest extends BaseSpecificationTest {

    @Test
    @DisplayName("Deve retornar entidades com nome terminando em '5' ou '0' e criadas entre duas datas")
    public void testNameEndsWithAndCreatedBetweenDatesSpecification() {
        // Given
        Date pastDate = new Date(System.currentTimeMillis() - 2000000000L);
        Date futureDate = new Date(System.currentTimeMillis() + 2000000000L);

        // Criando especificações individuais
        NameEndsWithSpecification<Entity> nameEndsWith5 = new NameEndsWithSpecification<>("5");
        NameEndsWithSpecification<Entity> nameEndsWith0 = new NameEndsWithSpecification<>("0");
        CreatedBetweenDatesSpecification<Entity> dateSpec = new CreatedBetweenDatesSpecification<>(pastDate, futureDate);

        // Combinando especificações
        Specification<Entity> specification = nameEndsWith5.or(nameEndsWith0).and(dateSpec);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            assertTrue(entity.getName().endsWith("5") || entity.getName().endsWith("0"),
                    "Todas as entidades devem ter nome terminando em '5' ou '0'");
            assertTrue(!entity.getCreated().before(pastDate) && !entity.getCreated().after(futureDate),
                    "Todas as entidades devem ter sido criadas entre as datas especificadas");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com comprimento de nome entre 8 e 10")
    public void testNameLengthSpecification() {
        // Given
        Specification<Entity> specification = new NameLengthSpecification<>(8, 10);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            int nameLength = entity.getName().length();
            boolean condition = nameLength >= 8 && nameLength <= 10;
            assertTrue(condition, "Todas as entidades devem ter comprimento de nome entre 8 e 10");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com nome contendo 'Entity' e tendo ID ímpar")
    public void testCustomSpecification() {
        // Given
        Predicate<Entity> predicate = entity ->
                entity.getName().contains("Entity") && entity.getId() % 2 != 0;

        Specification<Entity> specification = new CustomSpecification<>(predicate, "Nome contém 'Entity' e ID é ímpar");
        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertFalse(result.isEmpty(), "Deveria encontrar pelo menos uma entidade");
        result.forEach(entity -> {
            assertTrue(entity.getName().contains("Entity"), "Todas as entidades devem ter nome contendo 'Entity'");
            assertTrue(entity.getId() % 2 != 0, "Todas as entidades devem ter ID ímpar");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com nome correspondendo ao padrão 'Entity [1-5]'")
    public void testNameMatchesRegexSpecification() {
        // Given
        Specification<Entity> specification = new NameMatchesRegexSpecification<>("Entity [1-5]");

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertEquals(5, result.size(), "Deve retornar exatamente 5 entidades");
        result.forEach(entity -> {
            assertTrue(entity.getName().matches("Entity [1-5]"),
                    "Todas as entidades devem ter nome correspondendo ao padrão 'Entity [1-5]'");
        });
    }

    @Test
    @DisplayName("Deve retornar entidades com nome em uma coleção específica (case insensitive)")
    public void testNameInCollectionCaseInsensitiveSpecification() {
        // Given
        List<String> allowedNames = Arrays.asList("entity 1", "entity 3", "entity 5", "entity 7");
        Specification<Entity> specification = new NameInCollectionSpecification<>(allowedNames, true);

        // When
        List<Entity> result = repository.findAll(specification);

        // Then
        assertEquals(allowedNames.size(), result.size(),
                "Deve retornar exatamente o número de nomes permitidos");
        result.forEach(entity -> {
            boolean matchesAnyName = allowedNames.stream()
                    .anyMatch(name -> name.equalsIgnoreCase(entity.getName()));
            assertTrue(matchesAnyName, "O nome da entidade deve estar na lista de nomes permitidos (case insensitive)");
        });
    }
}
