package com.app.leave_manager.controller;

import com.app.leave_manager.manager.UserManager;
import com.app.leave_manager.model.dto.CreateUserRequest;
import com.app.leave_manager.model.dto.UserDto;
import com.app.leave_manager.reponse.ApiResponse;
import com.app.leave_manager.reponse.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserManager userManager;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addUser(@Valid @RequestBody CreateUserRequest request) {
        userManager.addUser(request);
        return ResponseUtils.buildResponse(HttpStatus.CREATED, "User added successfully");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        List<UserDto> users = userManager.getAllUsers();
        return ResponseUtils.buildResponse(HttpStatus.OK, users,"Users retrieved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long id) {
        return userManager.getUserById(id)
                .map(user -> ResponseUtils.buildResponse(HttpStatus.OK, user,"User retrieved successfully"))
                .orElse(ResponseUtils.buildResponse(HttpStatus.NOT_FOUND, "User not found with id: " + id));
    }
}
