package com.example.todotest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTodoRequest(
        @NotBlank(message = "title must not be blank")
        @Size(max = 120, message = "title must be at most 120 characters")
        String title,

        @Size(max = 1000, message = "description must be at most 1000 characters")
        String description
) {
}
