package br.com.code.enterprise.saga;

public enum SagaStatus {
    STARTED,
    EXECUTING,
    COMPENSATING,
    COMPLETED,
    FAILED
}
