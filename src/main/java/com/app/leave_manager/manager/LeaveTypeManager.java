package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.LeaveTypeMapper;
import com.app.leave_manager.model.dto.CreateLeaveTypeRequest;
import com.app.leave_manager.model.entities.LeaveType;
import com.app.leave_manager.model.entities.Tenant;
import com.app.leave_manager.service.LeaveTypeService;
import com.app.leave_manager.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class LeaveTypeManager {
    private final LeaveTypeService leaveTypeService;
    private final TenantService tenantService;
    private final LeaveTypeMapper leaveTypeMapper;

    @Transactional
    public void addLeaveType(CreateLeaveTypeRequest request) {
        Tenant tenant = tenantService.getTenantById(request.getTenantId());
        LeaveType leaveType = leaveTypeMapper.toEntity(request);
        leaveType.setTenant(tenant);
        leaveTypeService.addLeaveType(leaveType);
    }
}
