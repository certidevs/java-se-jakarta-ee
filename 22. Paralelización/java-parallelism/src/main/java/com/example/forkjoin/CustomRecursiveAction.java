package com.example.forkjoin;

import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {
    @Override
    protected void compute() {
        // La diferencia con las RecursiveTask es que las
        // Action no devuelven nada
    }
}
