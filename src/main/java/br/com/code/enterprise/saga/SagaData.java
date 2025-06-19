package br.com.code.enterprise.saga;

import java.util.Map;

public interface SagaData {
    String getSagaId();

    <T> T get(String key);

    void set(String key, Object value);

    Map<String, Object> getAll();
}
