package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAllByDeletedFalse();
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
