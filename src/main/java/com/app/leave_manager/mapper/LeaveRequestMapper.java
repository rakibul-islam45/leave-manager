package com.app.leave_manager.mapper;

import com.app.leave_manager.model.dto.LeaveRequestResponse;
import com.app.leave_manager.model.entities.LeaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "leaveType.id", target = "leaveTypeId")
    @Mapping(source = "leaveType.name", target = "leaveTypeName")
    LeaveRequestResponse toResponse(LeaveRequest leaveRequest);
    
}
