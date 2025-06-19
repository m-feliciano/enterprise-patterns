package br.com.code.patterns.creational.factorymethod;


public interface Creator {

    Product createProduct();


    default void someOperation() {

        Product product = createProduct();


        product.operation();
    }
}


interface Product {

    void operation();
}

