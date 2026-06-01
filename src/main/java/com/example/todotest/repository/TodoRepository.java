package com.example.todotest.repository;

import com.example.todotest.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    Todo save(Todo todo);

    List<Todo> findAll();

    Optional<Todo> findById(Long id);
}
