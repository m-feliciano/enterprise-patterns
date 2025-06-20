package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasPrice;

import java.math.BigDecimal;

/**
 * Especificação que verifica se o preço de uma entidade é menor que um valor específico.
 */
public class PriceLessThanSpecification<T extends HasPrice> extends AbstractSpecification<T> {

    private final BigDecimal price;

    public PriceLessThanSpecification(BigDecimal price) {
        this.price = price;
    }

    public PriceLessThanSpecification(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getPrice() != null && candidate.getPrice().compareTo(price) < 0;
    }
}
