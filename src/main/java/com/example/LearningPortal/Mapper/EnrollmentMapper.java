package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.enrollmentDTO;
import com.example.LearningPortal.entity.enrollment;

@Mapper(componentModel = "spring", uses = { userMapper.class, courseMapper.class })

public interface enrollmentMapper {

	enrollmentMapper INSTANCE = Mappers.getMapper(enrollmentMapper.class);

	@Mapping(source = "enrollment.learner.userId", target = "learnerId")
	enrollmentDTO enrollmentToEnrollmentDTO(enrollment enrollment);

	enrollment enrollmentDTOToEnrollment(enrollmentDTO enrollmentDTO);

}
