package com.app.leave_manager.controller;

import com.app.leave_manager.model.dto.LeaveRequestDto;
import com.app.leave_manager.model.dto.LeaveRequestResponse;
import com.app.leave_manager.model.enums.Status;
import com.app.leave_manager.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/leave-request")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @PostMapping("/apply")
    public ResponseEntity<LeaveRequestResponse> applyForLeave(@Valid @RequestBody LeaveRequestDto dto) {
        LeaveRequestResponse response = leaveRequestService.applyForLeave(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<LeaveRequestResponse>> getAllLeaveRequests(@ParameterObject Pageable pageable) {

        Page<LeaveRequestResponse> leaveRequests = leaveRequestService.getAllLeaveRequests(pageable);
        return ResponseEntity.ok(leaveRequests);
    }

    @GetMapping("/by-status")
    public ResponseEntity<Page<LeaveRequestResponse>> getLeaveRequestsByStatus(
            @RequestParam Status status, @ParameterObject Pageable pageable) {

        Page<LeaveRequestResponse> leaveRequests = leaveRequestService.getLeaveRequestsByStatus(status, pageable);
        return ResponseEntity.ok(leaveRequests);
    }
}
