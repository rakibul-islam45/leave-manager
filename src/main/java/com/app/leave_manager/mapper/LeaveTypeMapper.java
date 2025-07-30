package com.app.leave_manager.mapper;

import com.app.leave_manager.model.dto.CreateLeaveTypeRequest;
import com.app.leave_manager.model.entities.LeaveType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "leaveBalances", ignore = true)
    LeaveType toEntity(CreateLeaveTypeRequest request);
}
