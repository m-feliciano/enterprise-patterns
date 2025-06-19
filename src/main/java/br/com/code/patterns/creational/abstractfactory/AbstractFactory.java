package br.com.code.patterns.creational.abstractfactory;


public interface AbstractFactory {

    ProductA createProductA();


    ProductB createProductB();
}


interface ProductA {
    String getDescription();
}


interface ProductB {
    String getDescription();

    void interact(ProductA productA);
}

