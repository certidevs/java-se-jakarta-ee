package com.example.demo.behavioral.interpreter.expression;

import com.example.demo.behavioral.interpreter.Parser;

public interface Expression {
    int interpret(Parser operation);
}
