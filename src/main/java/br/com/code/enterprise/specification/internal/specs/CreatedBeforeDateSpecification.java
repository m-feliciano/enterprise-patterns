package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasCreationDate;

import java.util.Date;

/**
 * Especificação que verifica se uma entidade foi criada antes de uma determinada data.
 */
public class CreatedBeforeDateSpecification<T extends HasCreationDate> extends AbstractSpecification<T> {

    private final Date date;

    public CreatedBeforeDateSpecification(Date date) {
        this.date = date;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getCreated() != null && candidate.getCreated().before(date);
    }
}
