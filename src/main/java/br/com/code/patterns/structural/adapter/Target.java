package br.com.code.patterns.structural.adapter;


public interface Target {

    void request();
}


interface Adaptee {

    void specificRequest();
}


interface Adapter extends Target {


}

