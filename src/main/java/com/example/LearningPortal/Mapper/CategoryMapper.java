package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.CategoryDTO;
import com.example.LearningPortal.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO categoryToCategoryDTO(Category category);

	Category categoryDTOToCategory(CategoryDTO categoryDTO);

}
