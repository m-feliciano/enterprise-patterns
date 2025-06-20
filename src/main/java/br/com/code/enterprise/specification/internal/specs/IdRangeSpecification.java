package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasId;

public class IdRangeSpecification<T extends HasId> extends AbstractSpecification<T> {

    private final Long minId;
    private final Long maxId;

    public IdRangeSpecification(Long minId, Long maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getId() != null
               && candidate.getId() >= minId
               && candidate.getId() <= maxId;
    }
}
