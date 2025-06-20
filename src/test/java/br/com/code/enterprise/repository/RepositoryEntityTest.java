package br.com.code.enterprise.repository;

import br.com.code.enterprise.repository.stub.EntityStubRepository;
import br.com.code.enterprise.specification.Specification;
import br.com.code.enterprise.specification.internal.specs.NameContainsSpecification;
import br.com.code.enterprise.specification.model.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryEntityTest {

    private EntityStubRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new EntityStubRepository();
    }

    @Test
    public void testRepositoryMethods() {
        // Test findById
        var entity = repository.save(new Entity("Test Entity"));
        var foundEntity = repository.findById(entity.getId());
        Assertions.assertNotNull(foundEntity);
    }

    @Test
    public void testSaveEntity() {
        var entity = new Entity("New Entity");
        var savedEntity = repository.save(entity);
        Assertions.assertNotNull(savedEntity);
        Assertions.assertEquals("New Entity", savedEntity.getName());
        Assertions.assertNotNull(savedEntity.getId());
    }

    @Test
    public void testFindAllEntities() {
        repository.save(new Entity("Entity 1"));
        repository.save(new Entity("Entity 2"));
        var entities = repository.findAll();
        Assertions.assertFalse(entities.isEmpty());
        Assertions.assertEquals(2, entities.size());
    }

    @Test
    public void testDeleteEntity() {
        var entity = repository.save(new Entity("Entity to Delete"));
        repository.delete(entity);
        var foundEntity = repository.findById(entity.getId());
        Assertions.assertTrue(foundEntity.isEmpty());
    }

    @Test
    public void testDeleteById() {
        var entity = repository.save(new Entity("Entity to Delete by ID"));
        repository.deleteById(entity.getId());
        var foundEntity = repository.findById(entity.getId());
        Assertions.assertTrue(foundEntity.isEmpty());
    }

    @Test
    public void testFindOneWithSpecification() {
        var entity = repository.save(new Entity("Entity with Specification"));

        Specification<Entity> specification = new NameContainsSpecification<>("Entity with Specification");
        var foundEntity = repository.findOne(specification);
        Assertions.assertTrue(foundEntity.isPresent());
        Assertions.assertEquals(entity.getId(), foundEntity.get().getId());
    }

    @Test
    public void testFindAllWithSpecification() {
        repository.save(new Entity("Entity 1"));
        repository.save(new Entity("Entity 2"));

        Specification<Entity> specification = new NameContainsSpecification<>("Entity 1");
        var entities = repository.findAll(specification);
        Assertions.assertEquals(1, entities.size());
        Assertions.assertEquals("Entity 1", entities.get(0).getName());
    }
}
