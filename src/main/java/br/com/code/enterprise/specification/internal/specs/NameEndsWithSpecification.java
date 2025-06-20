package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameEndsWithSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final String suffix;

    public NameEndsWithSpecification(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null && candidate.getName().endsWith(suffix);
    }
}
