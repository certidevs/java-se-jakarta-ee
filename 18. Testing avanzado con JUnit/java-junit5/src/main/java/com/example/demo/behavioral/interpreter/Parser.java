package com.example.demo.behavioral.interpreter;

import com.example.demo.behavioral.interpreter.expression.AdditionExpression;
import com.example.demo.behavioral.interpreter.expression.Expression;
import com.example.demo.behavioral.interpreter.expression.NumberExpression;
import com.example.demo.behavioral.interpreter.expression.SubtractionExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Context
 */
public class Parser {

    private final Stack<Expression> numbers = new Stack<>();
    private final Stack<Expression> operators = new Stack<>();

    public Parser(String formula) {

        for (String token : reverseFormula(formula)) {
            if (token.equals("+")) {
                operators.add(new AdditionExpression());
            } else if (token.equals("-")) {
                operators.add(new SubtractionExpression());
//            } else if (token.equals("/")) {
//                operatori.add(new Divisione());
//            } else if (token.equals("*")) {
//                operatori.add(new Moltiplicazione());
            } else {
                numbers.add(new NumberExpression(token));
            }
        }
    }

    public Expression popNumber() {
        return numbers.pop();
    }

    public void pushNumber(Expression exp) {
        numbers.push(exp);
    }

    public Expression popOperator() {
        return operators.pop();
    }

    public boolean isEmptyOperators(){
        return operators.empty();
    }

    private String[] reverseFormula(String formula) {
        List<String> formulaOperators = Arrays.asList(formula.split(" "));
        Collections.reverse(formulaOperators);
        return formulaOperators.toArray(new String[0]);
    }
}
