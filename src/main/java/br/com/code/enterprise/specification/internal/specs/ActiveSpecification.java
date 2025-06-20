package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasActive;

public class ActiveSpecification<T extends HasActive> extends AbstractSpecification<T> {

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.isActive();
    }
}