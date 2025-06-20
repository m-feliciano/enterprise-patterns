package br.com.code.enterprise.specification.repository;

import br.com.code.enterprise.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    T save(T entity);

    Optional<T> findById(Class<T> entityType, ID id);

    List<T> findAll(Specification<T> specification);

    Optional<T> findOne(Specification<T> specification);

    void delete(T entity);

    T update(T entity);
}
