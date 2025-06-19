package br.com.code.patterns.behavioral.memento;


public interface Memento {

    String getCreationDate();


    String getName();
}


interface Originator {

    Memento save();


    void restore(Memento memento);
}


interface Caretaker {

    void addMemento(Memento memento);


    Memento getMemento(int index);
}

