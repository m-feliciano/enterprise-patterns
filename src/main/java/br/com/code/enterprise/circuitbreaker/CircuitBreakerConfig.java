package br.com.code.enterprise.circuitbreaker;

import java.util.List;

/**
 * Interface que define a configuração para um circuit breaker.
 */
public interface CircuitBreakerConfig {
    int getFailureThreshold();

    long getResetTimeoutMs();

    int getSuccessThreshold();

    List<Class<? extends Exception>> getRecordedExceptions();

    List<Class<? extends Exception>> getIgnoredExceptions();
}
