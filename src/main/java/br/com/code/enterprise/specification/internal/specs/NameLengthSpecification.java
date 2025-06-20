package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

public class NameLengthSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final int minLength;
    private final int maxLength;

    public NameLengthSpecification(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null
               && candidate.getName().length() >= minLength
               && candidate.getName().length() <= maxLength;
    }
}
