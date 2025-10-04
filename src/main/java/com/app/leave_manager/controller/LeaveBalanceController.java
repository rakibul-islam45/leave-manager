package com.app.leave_manager.controller;

import com.app.leave_manager.model.entities.LeaveBalance;
import com.app.leave_manager.reponse.ApiResponse;
import com.app.leave_manager.reponse.ResponseUtils;
import com.app.leave_manager.service.LeaveBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leave-balances")
@RequiredArgsConstructor
public class LeaveBalanceController {

    private final LeaveBalanceService leaveBalanceService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<LeaveBalance>>> getUserLeaveBalances(@PathVariable Long userId) {
        return ResponseUtils.buildResponse(HttpStatus.OK, leaveBalanceService.getUserLeaveBalances(userId), "Successfully retrieved leave balances");
    }

    @GetMapping("/{userId}/type/{leaveTypeId}")
    public ResponseEntity<ApiResponse<LeaveBalance>> getUserLeaveBalanceByType(
            @PathVariable Long userId,
            @PathVariable Long leaveTypeId) {
        return ResponseUtils.buildResponse(HttpStatus.OK, leaveBalanceService.getUserLeaveBalanceByType(userId, leaveTypeId), "Successfully retrieved leave balance by type");
    }
}
