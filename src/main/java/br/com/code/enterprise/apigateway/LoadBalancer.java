package br.com.code.enterprise.apigateway;

import java.util.List;

public interface LoadBalancer {
    String selectInstance(String serviceId, List<String> instances);
}
