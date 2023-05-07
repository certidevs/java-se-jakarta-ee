package com.example.casodeuso;

import com.example.operaciones.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskRepository {

    Map<Long, Task> tasks = new HashMap<>();

    public Optional<Task> findById(Long id){
        return Optional.ofNullable(tasks.get(id));
    }

    public String findTitleById(Long id){
//        return this.findById(id)
//                .map(Task::getTitle)
//                .orElse("default");

//        return this.findById(id)
//                .map(Task::getTitle)
//                .orElseThrow();

        return this.findById(id)
                .map(Task::getTitle)
                .orElseThrow(() -> new NotFoundException(String.format("No task for id '%s'", id)));
    }


}
