package br.com.code.patterns.behavioral.state;


public interface State {

    void handle(Context context);
}


interface Context {

    void changeState(State state);


    void request();
}

