package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.EnrollmentDTO;
import com.example.LearningPortal.entity.Enrollment;

@Mapper(componentModel = "spring", uses = { UserMapper.class, CourseMapper.class })

public interface EnrollmentMapper {

	EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

	@Mapping(source = "enrollment.learner.userId", target = "learnerId")
	EnrollmentDTO enrollmentToEnrollmentDTO(Enrollment enrollment);

	Enrollment enrollmentDTOToEnrollment(EnrollmentDTO enrollmentDTO);

}
