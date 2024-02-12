package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.UserDTO;
import com.example.LearningPortal.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "user.role", target = "role")
	UserDTO userToUserDTO(User user);

	User userDTOToUser(UserDTO userDTO);

}
