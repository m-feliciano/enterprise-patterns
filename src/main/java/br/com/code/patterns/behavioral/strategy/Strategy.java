package br.com.code.patterns.behavioral.strategy;


public interface Strategy {

    Object execute(Object data);
}


interface Context {

    void setStrategy(Strategy strategy);


    Object executeStrategy(Object data);
}

