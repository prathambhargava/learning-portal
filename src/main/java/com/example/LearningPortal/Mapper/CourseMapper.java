package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.courseDTO;
import com.example.LearningPortal.entity.course;

@Mapper(componentModel = "spring", uses = { categoryMapper.class, userMapper.class })
public interface courseMapper {

	courseMapper INSTANCE = Mappers.getMapper(courseMapper.class);

	@Mapping(source = "course.author.userId", target = "authorId")
	@Mapping(source = "course.category.name", target = "category")
	courseDTO courseToCourseDTO(course course);

	course courseDTOToCourse(courseDTO courseDTO);

}
