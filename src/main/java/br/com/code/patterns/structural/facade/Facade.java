package br.com.code.patterns.structural.facade;


public interface Facade {

    void operation();
}


interface Subsystem1 {

    String operation1();
}


interface Subsystem2 {

    String operation2();
}


interface Subsystem3 {

    String operation3();
}

