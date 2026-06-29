package com.example.todotest.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id) {
        super("Todo with id " + id + " was not found");
    }
}
