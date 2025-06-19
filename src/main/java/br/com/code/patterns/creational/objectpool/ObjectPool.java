package br.com.code.patterns.creational.objectpool;


public interface ObjectPool<T> {

    T acquire();


    void release(T object);


    int availableObjects();


    int totalObjects();


    void shutdown();
}

