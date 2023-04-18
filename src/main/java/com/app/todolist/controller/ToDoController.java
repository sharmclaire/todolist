package com.app.todolist.controller;

import com.app.todolist.model.ToDoEntity;
import com.app.todolist.request.ToDoRequest;
import com.app.todolist.response.ToDoResponse;
import com.app.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDoResponse> addToDo(@RequestBody ToDoRequest request) throws Exception {
        return new ResponseEntity<>(toDoService.addToDo(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoEntity> getToDoById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(toDoService.getToDoById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ToDoEntity>> getAllToDos(){
        return new ResponseEntity<>(toDoService.getAllToDos(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> updateToDo(@PathVariable Long id,
                                                   @RequestBody ToDoRequest request){
        return new ResponseEntity<>(toDoService.updateToDo(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoResponse> deleteToDoById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(toDoService.deleteToDoById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ToDoResponse> deleteAllToDos(){
        return new ResponseEntity<>(toDoService.deleteAllToDos(), HttpStatus.OK);
    }

}
