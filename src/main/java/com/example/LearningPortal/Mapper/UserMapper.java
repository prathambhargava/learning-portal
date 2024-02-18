package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.userDTO;
import com.example.LearningPortal.entity.user;

@Mapper(componentModel = "spring")
public interface userMapper {

	userMapper INSTANCE = Mappers.getMapper(userMapper.class);

	@Mapping(source = "user.role", target = "role")
	userDTO userToUserDTO(user user);

	user userDTOToUser(userDTO userDTO);

}
