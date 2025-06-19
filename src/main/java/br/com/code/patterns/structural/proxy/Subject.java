package br.com.code.patterns.structural.proxy;


public interface Subject {

    void request();
}


interface RealSubject extends Subject {

    void additionalOperation();
}

