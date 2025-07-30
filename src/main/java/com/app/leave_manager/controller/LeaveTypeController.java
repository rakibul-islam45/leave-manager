package com.app.leave_manager.controller;

import com.app.leave_manager.manager.LeaveTypeManager;
import com.app.leave_manager.model.dto.CreateLeaveTypeRequest;
import com.app.leave_manager.reponse.ApiResponse;
import com.app.leave_manager.reponse.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leave-types")
public class LeaveTypeController {
    private final LeaveTypeManager leaveTypeManager;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addLeaveType(@Valid @RequestBody CreateLeaveTypeRequest request) {
        leaveTypeManager.addLeaveType(request);
        return ResponseUtils.buildResponse(HttpStatus.CREATED, "Leave type added successfully");
    }
}
