package com.app.todolist.service.dao.impl;

import com.app.todolist.service.dao.ToDoDAO;
import com.app.todolist.model.ToDoEntity;
import com.app.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoDAOImpl implements ToDoDAO {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity){
        return toDoRepository.save(toDoEntity);
    }
    @Override
    public List<ToDoEntity> getAllToDos(){
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDoEntity> findById(Long id){
        return toDoRepository.findById(id);
    }

    @Override
    public void deleteToDoById(Long id){
        toDoRepository.deleteById(id);
    }

    @Override
    public void deleteAllToDos(){
        toDoRepository.deleteAll();
    }

}
