package br.com.code.enterprise.dependencyinjection;

public interface Injector {
    void inject(Object target);

    <T> T createInstance(Class<T> type);
}
