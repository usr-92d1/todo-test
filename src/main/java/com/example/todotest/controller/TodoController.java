package com.example.todotest.controller;

import com.example.todotest.dto.CreateTodoRequest;
import com.example.todotest.dto.TodoResponse;
import com.example.todotest.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse createTodo(@Valid @RequestBody CreateTodoRequest request) {
        return TodoResponse.from(todoService.create(request));
    }

    @GetMapping
    public List<TodoResponse> getTodos() {
        return todoService.findAll()
                .stream()
                .map(TodoResponse::from)
                .toList();
    }
}
