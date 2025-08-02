package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LeaveBalanceService leaveBalanceService;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
        leaveBalanceService.createLeaveBalancesForNewUser(user);
    }
}
