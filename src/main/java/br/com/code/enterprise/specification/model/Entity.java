package br.com.code.enterprise.specification.model;

import br.com.code.enterprise.specification.internal.interfaces.HasActive;
import br.com.code.enterprise.specification.internal.interfaces.HasCreationDate;
import br.com.code.enterprise.specification.internal.interfaces.HasId;
import br.com.code.enterprise.specification.internal.interfaces.HasName;
import br.com.code.enterprise.specification.internal.interfaces.HasPrice;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Entity implements HasActive, HasId, HasName, HasPrice, HasCreationDate {

    private Long id;
    private String name;
    private String description;
    private boolean active;
    private Date created;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Id: " + id +
               ", Name: " + name +
               ", Description: " + description +
               ", Active: " + active +
               ", Created: " + created +
               ", Price: " + price;
    }
}
