package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameStartsWithSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final String prefix;

    public NameStartsWithSpecification(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null && candidate.getName().startsWith(prefix);
    }
}