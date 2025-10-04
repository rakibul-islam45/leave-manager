package com.app.leave_manager.service;

import com.app.leave_manager.mapper.LeaveRequestMapper;
import com.app.leave_manager.model.dto.LeaveRequestDto;
import com.app.leave_manager.model.dto.LeaveRequestResponse;
import com.app.leave_manager.model.entities.LeaveBalance;
import com.app.leave_manager.model.entities.LeaveRequest;
import com.app.leave_manager.model.entities.LeaveType;
import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.model.enums.Status;
import com.app.leave_manager.repository.LeaveBalanceRepository;
import com.app.leave_manager.repository.LeaveRequestRepository;
import com.app.leave_manager.repository.LeaveTypeRepository;
import com.app.leave_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final UserRepository userRepository;
    private final LeaveRequestMapper leaveRequestMapper;

    @Transactional
    public LeaveRequestResponse applyForLeave(LeaveRequestDto dto) {
        // Validate dates
        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new IllegalArgumentException("End date must be after or equal to start date");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        LeaveType leaveType = leaveTypeRepository.findById(dto.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave type not found with ID: " + dto.getLeaveTypeId()));

        LeaveBalance balance = leaveBalanceRepository.findByUserIdAndLeaveTypeId(dto.getUserId(), dto.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave balance not found for user ID: " + dto.getUserId() 
                        + " and leave type ID: " + dto.getLeaveTypeId()));

        int days = (int) ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate()) + 1;

        if (balance.getRemainingDays() < days) {
            throw new IllegalArgumentException("Insufficient leave balance. Required: " + days 
                    + " days, Available: " + balance.getRemainingDays() + " days");
        }

        LeaveRequest request = LeaveRequest.builder()
                .user(user)
                .leaveType(leaveType)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .days(days)
                .reason(dto.getReason())
                .status(Status.PENDING)
                .build();

        LeaveRequest savedRequest = leaveRequestRepository.save(request);

        return leaveRequestMapper.toResponse(savedRequest);
    }

    @Transactional(readOnly = true)
    public Page<LeaveRequestResponse> getAllLeaveRequests(Pageable pageable) {
        Page<LeaveRequest> leaveRequests = leaveRequestRepository.findAll(pageable);
        return leaveRequests.map(leaveRequestMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<LeaveRequestResponse> getLeaveRequestsByStatus(Status status, Pageable pageable) {
        Page<LeaveRequest> leaveRequests = leaveRequestRepository.findAllByStatus(status, pageable);
        return leaveRequests.map(leaveRequestMapper::toResponse);
    }
}
