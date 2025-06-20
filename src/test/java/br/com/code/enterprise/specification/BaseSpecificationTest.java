package br.com.code.enterprise.specification;

import br.com.code.enterprise.specification.model.Entity;
import br.com.code.enterprise.specification.repository.stub.EntityStubRepository;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.Date;

public abstract class BaseSpecificationTest {

    protected EntityStubRepository repository;
    protected Date referenceDate;

    @BeforeEach
    public void setup() {
        repository = new EntityStubRepository();
        mockData(repository);
        referenceDate = new Date(System.currentTimeMillis() - 1000000000L); // ~11 days ago
    }

    private void mockData(EntityStubRepository repository) {
        for (int i = 1; i <= 50; i++) {
            Entity entity = Entity.builder()
                    .id((long) i)
                    .name("Entity " + i)
                    .description("Description " + i)
                    .active(i % 2 == 0)
                    .created(getCreatedDate(i))
                    .price(getPrice(i))
                    .build();
            repository.save(entity);
        }
    }

    private Date getCreatedDate(int id) {
        long refTimestamp = System.currentTimeMillis() - 1000000000L;

        if (id % 2 == 0) {
            return new Date(refTimestamp - (id * 10000000L));
        } else {
            return new Date(refTimestamp + (id * 10000000L));
        }
    }

    private BigDecimal getPrice(int id) {
        if (id % 15 == 0) { // Divisível por 3 e 5
            return BigDecimal.valueOf(300.0);
        } else if (id % 3 == 0) { // Divisível por 3
            return BigDecimal.valueOf(50.0 + id);
        } else if (id % 5 == 0) { // Divisível por 5
            return BigDecimal.valueOf(450.0 + id);
        } else {
            return BigDecimal.valueOf(150.0 + id);
        }
    }
}
