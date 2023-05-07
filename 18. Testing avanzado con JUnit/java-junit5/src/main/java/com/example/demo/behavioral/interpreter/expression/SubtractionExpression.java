package com.example.demo.behavioral.interpreter.expression;

import com.example.demo.behavioral.interpreter.Parser;

public class SubtractionExpression implements Expression {

    @Override
    public int interpret(Parser parser) {
        int num1 = parser.popNumber().interpret(parser);
        int num2 = parser.popNumber().interpret(parser);
        int result = num1 - num2;
        parser.pushNumber(new NumberExpression(String.valueOf(result)));
        return result;
    }
}
