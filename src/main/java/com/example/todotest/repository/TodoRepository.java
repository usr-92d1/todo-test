package com.example.todotest.repository;

import com.example.todotest.model.Todo;

import java.util.List;

public interface TodoRepository {

    Todo save(Todo todo);

    List<Todo> findAll();
}
