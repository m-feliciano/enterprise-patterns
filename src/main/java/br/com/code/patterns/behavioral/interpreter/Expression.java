package br.com.code.patterns.behavioral.interpreter;

public interface Expression {
    Object interpret(Context context);
}

