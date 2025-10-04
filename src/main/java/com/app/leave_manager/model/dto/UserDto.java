package com.app.leave_manager.model.dto;

import com.app.leave_manager.model.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;
}
