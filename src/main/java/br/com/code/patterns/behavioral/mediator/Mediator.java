package br.com.code.patterns.behavioral.mediator;


public interface Mediator {

    void notify(Component sender, String event, Object data);
}


interface Component {

    void setMediator(Mediator mediator);
}

