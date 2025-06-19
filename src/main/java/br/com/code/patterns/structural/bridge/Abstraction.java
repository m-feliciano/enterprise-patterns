package br.com.code.patterns.structural.bridge;


public interface Abstraction {

    void operation();
}


interface Implementor {

    void operationImpl();
}


interface RefinedAbstraction extends Abstraction {

    void additionalOperation();
}

