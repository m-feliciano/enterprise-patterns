package br.com.code.enterprise.repository.stub;

import br.com.code.enterprise.repository.Repository;
import br.com.code.enterprise.specification.Specification;
import br.com.code.enterprise.specification.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityStubRepository implements Repository<Entity, Long> {

    private final List<Entity> list;

    public EntityStubRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public Entity save(Entity entity) {
        entity.setId((long) (list.size() + 1));
        list.add(entity);
        return entity;
    }

    @Override
    public List<Entity> findAll(Specification<Entity> specification) {
        return list.stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> findById(Long aLong) {
        return list.stream()
                .filter(entity -> entity.getId().equals(aLong))
                .findFirst();
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public Optional<Entity> findOne(Specification<Entity> specification) {
        return list.stream()
                .filter(specification::isSatisfiedBy)
                .findFirst();
    }

    @Override
    public void delete(Entity entity) {
        list.removeIf(e -> e.getId().equals(entity.getId()));
    }

    @Override
    public void deleteById(Long aLong) {
        list.removeIf(entity -> entity.getId().equals(aLong));
    }
}
