package br.com.code.patterns.creational.builder;


public interface Builder<T> {

    Builder<T> reset();


    Builder<T> buildPartA(String param);


    Builder<T> buildPartB(String param);


    Builder<T> buildPartC(String param);


    T build();
}


interface Director {

    void setBuilder(Builder<?> builder);


    void buildMinimalViableProduct();


    void buildFullFeaturedProduct();
}

