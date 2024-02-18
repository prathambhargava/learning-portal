package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.categoryDTO;
import com.example.LearningPortal.entity.category;

@Mapper(componentModel = "spring")
public interface categoryMapper {

	categoryMapper INSTANCE = Mappers.getMapper(categoryMapper.class);

	categoryDTO categoryToCategoryDTO(category category);

	category categoryDTOToCategory(categoryDTO categoryDTO);

}
