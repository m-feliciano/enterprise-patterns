package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasPrice;

import java.math.BigDecimal;

/**
 * Especificação que verifica se o preço de uma entidade é maior que um valor específico.
 */
public class PriceGreaterThanSpecification<T extends HasPrice> extends AbstractSpecification<T> {

    private final BigDecimal price;

    public PriceGreaterThanSpecification(BigDecimal price) {
        this.price = price;
    }

    public PriceGreaterThanSpecification(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getPrice() != null && candidate.getPrice().compareTo(price) > 0;
    }
}
