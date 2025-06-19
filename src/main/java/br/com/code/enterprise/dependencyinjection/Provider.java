package br.com.code.enterprise.dependencyinjection;

public interface Provider<T> {
    T get();
}
