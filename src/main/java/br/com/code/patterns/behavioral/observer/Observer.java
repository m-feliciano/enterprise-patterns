package br.com.code.patterns.behavioral.observer;

import java.util.List;


public interface Observer {

    void update(Subject subject, Object arg);
}


interface Subject {

    void attach(Observer observer);


    void detach(Observer observer);


    void notifyObservers(Object arg);


    List<Observer> getObservers();
}

