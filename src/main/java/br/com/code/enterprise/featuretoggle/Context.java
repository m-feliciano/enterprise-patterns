package br.com.code.enterprise.featuretoggle;

import java.util.Map;

public interface Context {

    <T> T getValue(String key);

    boolean hasKey(String key);

    Map<String, Object> getAllValues();
}
