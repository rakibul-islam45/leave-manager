package com.app.leave_manager.model.dto;

import com.app.leave_manager.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestResponse {
    private Long id;
    private Long userId;
    private String userName;
    private Long leaveTypeId;
    private String leaveTypeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer days;
    private String reason;
    private Status status;
    private String managerRemark;
}
