package com.app.leave_manager.service;

import com.app.leave_manager.model.dto.LeaveRequestDto;
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
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final LeaveTypeRepository leaveTypeRepository;
    private final UserRepository userRepository;

    public LeaveRequest applyForLeave(LeaveRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        LeaveType leaveType = leaveTypeRepository.findById(dto.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave type not found"));

        LeaveBalance balance = leaveBalanceRepository.findByUserIdAndLeaveTypeId(dto.getUserId(), dto.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave balance not found"));

        int days = (int) ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate()) + 1;
        if (balance.getRemainingDays() < days) {
            throw new RuntimeException("Insufficient leave balance");
        }

        LeaveRequest request = new LeaveRequest();
        request.setUser(user);
        request.setLeaveType(leaveType);
        request.setStartDate(dto.getStartDate());
        request.setEndDate(dto.getEndDate());
        request.setDays(days);
        request.setStatus(Status.PENDING);

        return leaveRequestRepository.save(request);
    }
}
