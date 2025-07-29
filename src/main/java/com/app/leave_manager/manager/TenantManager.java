package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.TenantMapper;
import com.app.leave_manager.model.dto.CreateTenantRequest;
import com.app.leave_manager.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TenantManager {
    private final TenantService tenantService;
    private final TenantMapper tenantMapper;

    @Transactional
    public void addTenant(CreateTenantRequest request) {
        var tenant = tenantMapper.toEntity(request);
        tenantService.addTenant(tenant);
    }
}
