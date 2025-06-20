package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasCreationDate;

import java.util.Date;

/**
 * Especificação que verifica se uma entidade foi criada após uma determinada data.
 */
public class CreatedAfterDateSpecification<T extends HasCreationDate> extends AbstractSpecification<T> {

    private final Date date;

    public CreatedAfterDateSpecification(Date date) {
        this.date = date;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getCreated() != null && candidate.getCreated().after(date);
    }
}
