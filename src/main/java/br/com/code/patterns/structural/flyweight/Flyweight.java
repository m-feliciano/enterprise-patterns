package br.com.code.patterns.structural.flyweight;


public interface Flyweight {

    void operation(Object extrinsicState);
}


interface FlyweightFactory {

    Flyweight getFlyweight(String key);


    int getFlyweightCount();
}

