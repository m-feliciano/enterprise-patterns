package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasId;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IdInCollectionSpecification<T extends HasId> extends AbstractSpecification<T> {

    private final Set<Long> allowedIds;

    public IdInCollectionSpecification(Collection<Long> allowedIds) {
        this.allowedIds = new HashSet<>(allowedIds);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getId() != null && allowedIds.contains(candidate.getId());
    }
}
