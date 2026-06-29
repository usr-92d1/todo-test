package com.example.todotest.service;

import com.example.todotest.dto.CreateTodoRequest;
import com.example.todotest.exception.TodoNotFoundException;
import com.example.todotest.model.Todo;
import com.example.todotest.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final Clock clock;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
        this.clock = Clock.systemUTC();
    }

    public Todo create(CreateTodoRequest request) {
        Todo todo = new Todo(
                null,
                request.title(),
                normalizeDescription(request.description()),
                false,
                Instant.now(clock)
        );
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    private String normalizeDescription(String description) {
        if (description == null || description.isBlank()) {
            return null;
        }
        return description.strip();
    }
}
