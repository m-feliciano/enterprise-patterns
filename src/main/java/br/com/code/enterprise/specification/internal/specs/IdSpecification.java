package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasId;

public class IdSpecification<T extends HasId> extends AbstractSpecification<T> {

    private final Long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getId() != null && candidate.getId().equals(id);
    }
}
