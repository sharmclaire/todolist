package com.app.todolist.service;

import com.app.todolist.model.ToDoEntity;
import com.app.todolist.request.ToDoRequest;
import com.app.todolist.response.ToDoResponse;

import java.util.List;

public interface ToDoService {
    ToDoResponse addToDo(ToDoRequest request) throws Exception;

    ToDoEntity getToDoById(Long id);

    List<ToDoEntity> getAllToDos();

    ToDoResponse updateToDo(Long id, ToDoRequest request);

    ToDoResponse deleteToDoById(Long id) throws Exception;

    ToDoResponse deleteAllToDos();

}
