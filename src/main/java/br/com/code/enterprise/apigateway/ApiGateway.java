package br.com.code.enterprise.apigateway;

public interface ApiGateway {
    // TODO: complete the method signatures for the ApiGateway interface
    void addFilter(Filter filter);

    void setLoadBalancer(LoadBalancer loadBalancer);

    void setCircuitBreaker(CircuitBreaker circuitBreaker);
}
