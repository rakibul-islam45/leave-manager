package com.app.leave_manager.mapper;

import com.app.leave_manager.config.CommonMapperConfig;
import com.app.leave_manager.model.dto.UserDto;
import com.app.leave_manager.model.entities.User;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface UserMapper {

     UserDto toDto(User user);
     User toEntity(UserDto userDto);

}
