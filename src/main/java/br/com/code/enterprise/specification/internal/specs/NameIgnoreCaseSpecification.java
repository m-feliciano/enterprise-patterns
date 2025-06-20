package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameIgnoreCaseSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final String name;

    public NameIgnoreCaseSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null
               && candidate.getName().equalsIgnoreCase(name);
    }
}
