package br.com.code.enterprise.circuitbreaker;

public interface CircuitBreakerMetrics {

    int getFailureCount();

    int getSuccessCount();

    long getLastFailureTime();

    float getFailureRate();

    int getNumberOfBufferedCalls();
}
