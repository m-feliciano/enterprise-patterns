package br.com.code.enterprise.apigateway;

import java.util.concurrent.Callable;

public interface CircuitBreaker {
    <T> T executeCall(String serviceId, Callable<T> call) throws Exception;
}
