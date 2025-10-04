package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.LeaveTypeMapper;
import com.app.leave_manager.model.dto.CreateLeaveTypeRequest;
import com.app.leave_manager.model.entities.LeaveType;
import com.app.leave_manager.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class LeaveTypeManager {
    private final LeaveTypeService leaveTypeService;
    private final LeaveTypeMapper leaveTypeMapper;

    @Transactional
    public void addLeaveType(CreateLeaveTypeRequest request) {
        LeaveType leaveType = leaveTypeMapper.toEntity(request);
        leaveTypeService.addLeaveType(leaveType);
    }
}
