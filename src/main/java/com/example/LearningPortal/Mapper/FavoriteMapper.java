package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.favoriteDTO;
import com.example.LearningPortal.entity.favorite;

@Mapper(componentModel = "spring")
public interface favoriteMapper {

	favoriteMapper INSTANCE = Mappers.getMapper(favoriteMapper.class);

	@Mapping(source = "favorite.learner.userId", target = "learnerId")
	favoriteDTO favoriteToFavoriteDTO(favorite favorite);

	favorite favoriteDTOToFavorite(favoriteDTO favoriteDTO);

}
