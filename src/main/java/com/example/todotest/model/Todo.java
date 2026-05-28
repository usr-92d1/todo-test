package com.example.todotest.model;

import java.time.Instant;

public record Todo(
        Long id,
        String title,
        String description,
        boolean completed,
        Instant createdAt
) {
}
