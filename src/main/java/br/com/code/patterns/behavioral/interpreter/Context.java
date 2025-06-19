package br.com.code.patterns.behavioral.interpreter;


public interface Context {
    void setVariable(String name, Object value);

    Object getVariable(String name);
}

