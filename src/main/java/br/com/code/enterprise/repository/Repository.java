package br.com.code.enterprise.repository;

import br.com.code.enterprise.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();

    Optional<T> findOne(Specification<T> specification);

    List<T> findAll(Specification<T> specification);

    T save(T entity);

    void delete(T entity);

    void deleteById(ID id);
}

