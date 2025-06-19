package br.com.code.enterprise.circuitbreaker;

import java.util.concurrent.Callable;
import java.util.function.Function;

public interface CircuitBreaker {

    <T> T executeCall(Callable<T> call) throws Exception;

    <T> T executeCall(Callable<T> call, Function<Exception, T> fallback);

    State getState();

    CircuitBreakerMetrics getMetrics();

    void reset();
}
