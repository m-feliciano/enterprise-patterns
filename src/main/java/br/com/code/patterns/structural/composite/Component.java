package br.com.code.patterns.structural.composite;

import java.util.List;


public interface Component {

    void operation();


    void add(Component component);


    void remove(Component component);


    Component getChild(int index);


    List<Component> getChildren();


    boolean isLeaf();
}

