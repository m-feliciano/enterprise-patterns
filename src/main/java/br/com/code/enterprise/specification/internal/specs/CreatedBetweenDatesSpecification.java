package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasCreationDate;

import java.util.Date;

/**
 * Especificação que verifica se uma entidade foi criada dentro de um intervalo de datas.
 */
public class CreatedBetweenDatesSpecification<T extends HasCreationDate> extends AbstractSpecification<T> {

    private final Date startDate;
    private final Date endDate;

    public CreatedBetweenDatesSpecification(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getCreated() != null
               && !candidate.getCreated().before(startDate)
               && !candidate.getCreated().after(endDate);
    }
}
