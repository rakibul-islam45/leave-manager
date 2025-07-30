package com.app.leave_manager.service;

import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }
}
