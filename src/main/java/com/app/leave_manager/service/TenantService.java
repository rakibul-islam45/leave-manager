package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.Tenant;
import com.app.leave_manager.repository.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TenantService {
    private final TenantRepository tenantRepository;

    public void addTenant(Tenant tenant) {
        tenantRepository.save(tenant);
    }

    public Tenant getTenantById(@NotNull(message = "Tenant ID is required") Long tenantId) {
        return tenantRepository.findById(tenantId)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with ID: " + tenantId));
    }
}
