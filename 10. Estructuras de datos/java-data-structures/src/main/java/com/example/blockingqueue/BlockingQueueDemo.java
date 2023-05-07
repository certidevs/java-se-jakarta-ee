package com.example.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
    Thread-safe Queue

    lanzan excepción:
    add()
    element()
    remove()

    no lanzan excepción:
    offer()
    peek()
    poll()

    métodos bloqueantes:
    put() si está llena espera a que haya hueco
    take() si está vacía espera a que haya un elemento

 */
public class BlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> animal1 = new ArrayBlockingQueue<>(5);

        BlockingQueue<String> animal2 = new LinkedBlockingQueue<>();
    }
}
