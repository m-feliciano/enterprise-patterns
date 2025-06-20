package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameContainsSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final String substring;

    public NameContainsSpecification(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null && candidate.getName().contains(substring);
    }
}
