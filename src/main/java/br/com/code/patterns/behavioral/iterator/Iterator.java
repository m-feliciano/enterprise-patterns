package br.com.code.patterns.behavioral.iterator;


public interface Iterator<T> {

    boolean hasNext();


    T next();
}


interface Iterable<T> {

    Iterator<T> iterator();
}

