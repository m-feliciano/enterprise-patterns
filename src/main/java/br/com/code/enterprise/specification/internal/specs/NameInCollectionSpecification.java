package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class NameInCollectionSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final Set<String> allowedNames;
    private final boolean ignoreCase;

    public NameInCollectionSpecification(Collection<String> allowedNames) {
        this(allowedNames, false);
    }

    public NameInCollectionSpecification(Collection<String> allowedNames, boolean ignoreCase) {
        this.allowedNames = new HashSet<>(allowedNames);
        this.ignoreCase = ignoreCase;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        if (candidate.getName() == null) {
            return false;
        }

        if (ignoreCase) {
            return allowedNames.stream()
                    .anyMatch(name -> name.equalsIgnoreCase(candidate.getName()));
        } else {
            return allowedNames.contains(candidate.getName());
        }
    }
}
