package br.com.code.enterprise.apigateway;

import java.util.List;
import java.util.Map;

public interface ServiceRegistry {
    void register(String serviceId, String endpoint);

    void deregister(String serviceId, String endpoint);

    String discover(String serviceId);

    List<String> getAllInstances(String serviceId);

    Map<String, List<String>> getAllServices();
}
