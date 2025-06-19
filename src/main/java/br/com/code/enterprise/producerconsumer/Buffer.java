package br.com.code.enterprise.producerconsumer;

public interface Buffer<T> {
    void put(T item) throws InterruptedException;

    T take() throws InterruptedException;

    boolean isEmpty();

    boolean isFull();
}
