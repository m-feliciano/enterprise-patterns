package br.com.code.patterns.structural.decorator;


public interface Component {

    String operation();
}


interface Decorator extends Component {

    Component getComponent();
}

