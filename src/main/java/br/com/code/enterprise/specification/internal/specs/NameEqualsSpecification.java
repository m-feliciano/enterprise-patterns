package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameEqualsSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final String exactName;

    public NameEqualsSpecification(String exactName) {
        this.exactName = exactName;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null && candidate.getName().equals(exactName);
    }
}
