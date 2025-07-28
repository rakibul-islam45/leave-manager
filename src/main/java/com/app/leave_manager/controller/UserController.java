package com.app.leave_manager.controller;

import com.app.leave_manager.manager.UserManager;
import com.app.leave_manager.model.dto.UserDto;
import com.app.leave_manager.reponse.ApiResponse;
import com.app.leave_manager.reponse.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserManager userManager;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addUser(@RequestBody UserDto user) {

        userManager.addUser(user);
        return ResponseUtils.buildResponse(HttpStatus.CREATED, "User added successfully");
    }
}
