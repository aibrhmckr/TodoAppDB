package com.aibrahimcakir.TodoService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private String taskId;
    private String task;
    private boolean isDone;
}
