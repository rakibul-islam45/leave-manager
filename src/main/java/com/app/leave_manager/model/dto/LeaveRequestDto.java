package com.app.leave_manager.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveRequestDto {

    Long userId;
    Long leaveTypeId;
    LocalDate startDate;
    LocalDate endDate;
}
