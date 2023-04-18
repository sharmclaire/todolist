package com.app.todolist.service.dao;

import com.app.todolist.model.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoDAO {
    ToDoEntity save(ToDoEntity toDoEntity);

    List<ToDoEntity> getAllToDos();

    Optional<ToDoEntity> findById(Long id);

    void deleteToDoById(Long id);

    void deleteAllToDos();
}
