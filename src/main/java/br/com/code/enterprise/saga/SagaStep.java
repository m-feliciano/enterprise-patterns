package br.com.code.enterprise.saga;

public interface SagaStep {
    // TODO: Define the methods that each SagaStep should implement
    String getName();

    int getOrder();
}
