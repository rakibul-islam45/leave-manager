package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.LeaveBalance;
import com.app.leave_manager.model.entities.LeaveType;
import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.repository.LeaveBalanceRepository;
import com.app.leave_manager.repository.LeaveTypeRepository;
import com.app.leave_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveBalanceService {
    private final LeaveBalanceRepository leaveBalanceRepository;
    private final UserRepository userRepository;
    private final LeaveTypeRepository leaveTypeRepository;

    @Transactional
    public void createLeaveBalancesForNewLeaveType(LeaveType leaveType) {
        List<User> users = userRepository.findAllByTenantIdAndDeletedFalse(leaveType.getTenant().getId());
        List<LeaveBalance> leaveBalances = users.stream()
                .map(user -> LeaveBalance.builder()
                        .user(user)
                        .leaveType(leaveType)
                        .remainingDays(leaveType.getDefaultDays())
                        .build())
                .collect(Collectors.toList());
        leaveBalanceRepository.saveAll(leaveBalances);
    }

    @Transactional
    public void createLeaveBalancesForNewUser(User user) {
        List<LeaveType> leaveTypes = leaveTypeRepository.findAllByTenantIdAndDeletedFalse(user.getTenant().getId());
        List<LeaveBalance> leaveBalances = leaveTypes.stream()
                .map(leaveType -> LeaveBalance.builder()
                        .user(user)
                        .leaveType(leaveType)
                        .remainingDays(leaveType.getDefaultDays())
                        .build())
                .collect(Collectors.toList());
        leaveBalanceRepository.saveAll(leaveBalances);
    }
}
