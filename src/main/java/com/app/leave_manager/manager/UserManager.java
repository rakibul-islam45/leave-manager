package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.UserMapper;
import com.app.leave_manager.model.dto.CreateUserRequest;
import com.app.leave_manager.model.dto.UserDto;
import com.app.leave_manager.model.entities.User;
import com.app.leave_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;
    private final UserMapper userMapper;

    @Transactional
    public void addUser(CreateUserRequest request) {
        User user = userMapper.toEntity(request);
        userService.addUser(user);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> getUserById(Long id) {
        return userService.getUserById(id)
                .map(userMapper::toDto);
    }
}
