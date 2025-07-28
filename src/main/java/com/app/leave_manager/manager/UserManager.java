package com.app.leave_manager.manager;

import com.app.leave_manager.mapper.UserMapper;
import com.app.leave_manager.model.dto.UserDto;
import com.app.leave_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;
    private final UserMapper userMapper;

    public void addUser(UserDto userDto) {
        userService.addUser(userMapper.toEntity(userDto));

    }
}
