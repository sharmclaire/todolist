package com.app.todolist.service.impl;

import com.app.todolist.model.ToDoEntity;
import com.app.todolist.repository.ToDoRepository;
import com.app.todolist.service.dao.ToDoDAO;
import com.app.todolist.request.ToDoRequest;
import com.app.todolist.response.ToDoResponse;
import com.app.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoDAO toDoDAO;

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public ToDoResponse addToDo(ToDoRequest request) throws Exception{
        ToDoResponse response = new ToDoResponse();

        ToDoEntity toDoEntity = new ToDoEntity();

        toDoDAO.save(toDoEntity.builder()
                .todo(request.getTodo())
                .completed(false)
                .build());

        response.setMessage("To Do added!");
        return response;
    }

    @Override
    public ToDoEntity getToDoById(Long id){
        ToDoEntity toDo = new ToDoEntity();
        toDoDAO.findById(id).ifPresent(toDoEntity -> {
            toDo.setId(toDoEntity.getId());
            toDo.setTodo(toDoEntity.getTodo());
            toDo.setCompleted(toDoEntity.isCompleted());
        });
        return toDo;
    }

    @Override
    public List<ToDoEntity> getAllToDos(){
        return toDoDAO.getAllToDos();
    }

    @Override
    public ToDoResponse updateToDo(Long id, ToDoRequest request){
        ToDoResponse response = new ToDoResponse();

        ToDoEntity toDoEntity = getToDoById(id);

        toDoDAO.save(toDoEntity.builder()
                .id(toDoEntity.getId())
                .todo(request.getTodo())
                .completed(request.isCompleted())
                .build());

        response.setMessage("To Do updated!");
        return response;
    }

    @Override
    public ToDoResponse deleteToDoById(Long id) throws Exception{
        ToDoResponse response = new ToDoResponse();

        ToDoEntity toDoEntity = getToDoById(id);

        toDoDAO.deleteToDoById(id);

        response.setMessage("To Do deleted!");
        return response;
    }

    @Override
    public ToDoResponse deleteAllToDos(){
        ToDoResponse response = new ToDoResponse();

        toDoDAO.deleteAllToDos();

        response.setMessage("All To Do's are deleted!");
        return response;
    }



}
