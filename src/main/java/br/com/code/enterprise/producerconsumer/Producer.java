package br.com.code.enterprise.producerconsumer;

public interface Producer<T> {
    void produce(Buffer<T> buffer) throws InterruptedException;
}
