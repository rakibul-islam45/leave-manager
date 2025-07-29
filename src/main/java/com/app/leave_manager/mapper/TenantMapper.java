package com.app.leave_manager.mapper;

import com.app.leave_manager.config.CommonMapperConfig;
import com.app.leave_manager.model.dto.CreateTenantRequest;
import com.app.leave_manager.model.entities.Tenant;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface TenantMapper {

    Tenant toEntity(CreateTenantRequest request);
}
