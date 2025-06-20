package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasPrice;

import java.math.BigDecimal;

/**
 * Especificação que verifica se o preço de uma entidade está dentro de um intervalo específico.
 */
public class PriceBetweenSpecification<T extends HasPrice> extends AbstractSpecification<T> {

    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public PriceBetweenSpecification(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public PriceBetweenSpecification(double minPrice, double maxPrice) {
        this.minPrice = BigDecimal.valueOf(minPrice);
        this.maxPrice = BigDecimal.valueOf(maxPrice);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getPrice() != null
               && candidate.getPrice().compareTo(minPrice) >= 0
               && candidate.getPrice().compareTo(maxPrice) <= 0;
    }
}
