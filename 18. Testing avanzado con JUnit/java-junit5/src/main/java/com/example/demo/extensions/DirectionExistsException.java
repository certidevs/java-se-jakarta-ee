package com.example.demo.extensions;

public class DirectionExistsException extends Exception {
    private Direction direction;

    public DirectionExistsException(Direction direction, String message) {
        super(message);
        this.direction = direction;
    }
}