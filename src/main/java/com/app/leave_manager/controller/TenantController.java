package com.app.leave_manager.controller;

import com.app.leave_manager.manager.TenantManager;
import com.app.leave_manager.model.dto.CreateTenantRequest;
import com.app.leave_manager.reponse.ApiResponse;
import com.app.leave_manager.reponse.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tenants")
public class TenantController {
    private final TenantManager tenantManager;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addTenant(@Valid @RequestBody CreateTenantRequest request) {
        tenantManager.addTenant(request);
        return ResponseUtils.buildResponse(HttpStatus.CREATED, "Tenant added successfully");
    }
}
