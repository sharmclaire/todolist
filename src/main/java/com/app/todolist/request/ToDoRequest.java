package com.app.todolist.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoRequest {

    private String todo;

    private boolean completed;

}
