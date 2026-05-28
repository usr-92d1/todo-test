package com.example.todotest.repository;

import com.example.todotest.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final AtomicLong idSequence = new AtomicLong(1);
    private final ConcurrentMap<Long, Todo> todos = new ConcurrentHashMap<>();

    @Override
    public Todo save(Todo todo) {
        Long id = idSequence.getAndIncrement();
        Todo savedTodo = new Todo(
                id,
                todo.title(),
                todo.description(),
                todo.completed(),
                todo.createdAt()
        );
        todos.put(id, savedTodo);
        return savedTodo;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> result = new ArrayList<>(todos.values());
        result.sort(Comparator.comparing(Todo::id));
        return result;
    }
}
