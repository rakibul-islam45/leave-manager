package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.UserMapper;
import com.app.leave_manager.model.dto.CreateUserRequest;
import com.app.leave_manager.model.entities.Tenant;
import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.service.TenantService;
import com.app.leave_manager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;
    private final TenantService tenantService;
    private final UserMapper userMapper;

    @Transactional
    public void addUser(CreateUserRequest request) {
        // Verify tenant exists before creating user
        Tenant tenant = tenantService.getTenantById(request.getTenantId());
        User user = userMapper.toEntity(request);
        user.setTenant(tenant);
        userService.addUser(user);
    }
}
