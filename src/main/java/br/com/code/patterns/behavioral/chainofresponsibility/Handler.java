package br.com.code.patterns.behavioral.chainofresponsibility;


public interface Handler {

    Handler setNext(Handler nextHandler);


    boolean handle(Object request);
}

