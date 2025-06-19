package br.com.code.enterprise.producerconsumer;

public interface Consumer<T> {
    void consume(Buffer<T> buffer) throws InterruptedException;
}
