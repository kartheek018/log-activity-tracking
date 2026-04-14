package com.LogActivity.api.infra.api.server.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestDto {

    @Schema(description = "User name", example = "Kartheek")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "User email", example = "gnanakartheek@gmail.com")
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}