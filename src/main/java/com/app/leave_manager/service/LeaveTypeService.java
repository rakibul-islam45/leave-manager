package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.LeaveType;
import com.app.leave_manager.repository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeaveTypeService {
    private final LeaveTypeRepository leaveTypeRepository;

    @Transactional
    public void addLeaveType(LeaveType leaveType) {
        if (leaveTypeRepository.existsByNameAndTenantIdAndDeletedFalse(leaveType.getName(), leaveType.getTenant().getId())) {
            throw new IllegalArgumentException("Leave type with this name already exists for the tenant");
        }
        leaveTypeRepository.save(leaveType);
    }
}
