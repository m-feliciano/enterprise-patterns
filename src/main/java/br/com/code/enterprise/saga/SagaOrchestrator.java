package br.com.code.enterprise.saga;

public interface SagaOrchestrator {
    String start(SagaData sagaData);

    void end(String sagaId, SagaStatus status);

    void compensate(String sagaId, String step);

    SagaStatus getStatus(String sagaId);
    // TODO: Complete the SagaOrchestrator interface with necessary methods
}
