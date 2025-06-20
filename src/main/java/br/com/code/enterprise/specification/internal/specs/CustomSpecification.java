package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;

import java.util.function.Predicate;

public class CustomSpecification<T> extends AbstractSpecification<T> {

    private final Predicate<T> predicate;
    private final String description;

    public CustomSpecification(Predicate<T> predicate, String description) {
        this.predicate = predicate;
        this.description = description;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return predicate.test(candidate);
    }

    @Override
    public String toString() {
        return "CustomSpecification: " + description;
    }
}
