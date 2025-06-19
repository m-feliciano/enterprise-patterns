package br.com.code.enterprise.circuitbreaker;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CircuitBreakerRegistry {
    CircuitBreaker getCircuitBreaker(String name);

    Optional<CircuitBreaker> findCircuitBreaker(String name);

    List<CircuitBreaker> getAllCircuitBreakers();

    Map<String, CircuitBreaker> getCircuitBreakerMap();

    CircuitBreaker addCircuitBreaker(String name, CircuitBreaker circuitBreaker);

    void removeCircuitBreaker(String name);
}
