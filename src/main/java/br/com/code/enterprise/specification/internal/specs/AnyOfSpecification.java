package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.Specification;
import br.com.code.enterprise.specification.internal.AbstractSpecification;

import java.util.Arrays;
import java.util.Collection;


public class AnyOfSpecification<T> extends AbstractSpecification<T> {

    private final Collection<Specification<T>> specifications;

    @SafeVarargs
    public AnyOfSpecification(Specification<T>... specifications) {
        this.specifications = Arrays.asList(specifications);
    }

    public AnyOfSpecification(Collection<Specification<T>> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return specifications.stream()
                .anyMatch(spec -> spec.isSatisfiedBy(candidate));
    }
}
