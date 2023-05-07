package com.example.demo.extensions;

public interface DirectionDAO {

    void insert(Direction direction) throws DirectionExistsException;
    void delete(Direction direction);
    Direction getById(Long id);
}
