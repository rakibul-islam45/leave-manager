package com.app.leave_manager.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLeaveTypeRequest {
    @NotBlank(message = "Leave type name is required")
    private String name;

    @NotNull(message = "Default quota is required")
    @Positive(message = "Default quota must be positive")
    private Integer defaultQuota;

    @NotNull(message = "Tenant ID is required")
    private Long tenantId;
}
