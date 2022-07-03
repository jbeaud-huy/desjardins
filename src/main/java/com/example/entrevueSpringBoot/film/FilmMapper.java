package com.example.entrevueSpringBoot.film;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

	FilmDto toFilmDto(Film Film);

	Film toFilm(FilmDto FilmDto);

	List<FilmDto> toFilmDtos(List<Film> films);

}