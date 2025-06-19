package br.com.code.enterprise.dependencyinjection;

public interface Container {
    <T> void register(Class<T> type, Class<? extends T> implementation);

    <T> void register(Class<T> type, T instance);

    <T> void register(Class<T> type, Provider<T> provider);

    <T> T resolve(Class<T> type);

    <T> T resolve(Class<T> type, String qualifier);
}
