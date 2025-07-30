package com.app.leave_manager.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTenantRequest {
    @NotBlank(message = "Name is required")
    private String name;
}
