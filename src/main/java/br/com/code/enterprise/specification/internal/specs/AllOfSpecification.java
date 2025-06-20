package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.Specification;
import br.com.code.enterprise.specification.internal.AbstractSpecification;

import java.util.Arrays;
import java.util.Collection;

/**
 * Uma especificação composta que representa a conjunção lógica (AND) de várias
 * especificações. Uma entidade satisfaz esta especificação se satisfizer TODAS
 * as especificações contidas.
 */
public class AllOfSpecification<T> extends AbstractSpecification<T> {

    private final Collection<Specification<T>> specifications;

    @SafeVarargs
    public AllOfSpecification(Specification<T>... specifications) {
        this.specifications = Arrays.asList(specifications);
    }

    public AllOfSpecification(Collection<Specification<T>> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return specifications.stream()
                .allMatch(spec -> spec.isSatisfiedBy(candidate));
    }
}
