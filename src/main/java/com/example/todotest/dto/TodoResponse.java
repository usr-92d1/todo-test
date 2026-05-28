package com.example.todotest.dto;

import com.example.todotest.model.Todo;

import java.time.Instant;

public record TodoResponse(
        Long id,
        String title,
        String description,
        boolean completed,
        Instant createdAt
) {

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.id(),
                todo.title(),
                todo.description(),
                todo.completed(),
                todo.createdAt()
        );
    }
}
