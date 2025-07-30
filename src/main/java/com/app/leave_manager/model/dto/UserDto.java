package com.app.leave_manager.model.dto;

import com.app.leave_manager.model.entities.Tenant;
import com.app.leave_manager.model.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String name;

    private String email;

    private String password;

    private Role role;

    private Tenant tenant;
}
