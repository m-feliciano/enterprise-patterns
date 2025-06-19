package br.com.code.patterns.behavioral.command;


public interface Command {

    void execute();


    default void undo() {

    }
}

