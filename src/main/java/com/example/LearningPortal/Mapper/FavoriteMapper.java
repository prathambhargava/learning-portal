package com.example.LearningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.FavoriteDTO;
import com.example.LearningPortal.entity.Favorite;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

	FavoriteMapper INSTANCE = Mappers.getMapper(FavoriteMapper.class);

	@Mapping(source = "favorite.learner.userId", target = "learnerId")
	FavoriteDTO favoriteToFavoriteDTO(Favorite favorite);

	Favorite favoriteDTOToFavorite(FavoriteDTO favoriteDTO);

}
