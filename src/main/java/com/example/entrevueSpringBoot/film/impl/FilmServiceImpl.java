package com.example.entrevueSpringBoot.film.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.film.Film;
import com.example.entrevueSpringBoot.film.FilmDto;
import com.example.entrevueSpringBoot.film.FilmMapper;
import com.example.entrevueSpringBoot.film.FilmRepository;
import com.example.entrevueSpringBoot.film.FilmService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private FilmMapper filmMapper;

	@Override
	public Optional<FilmDto> getFilm(Integer filmId) {
		Optional<Film> filmOptional = filmRepository.findById(filmId);
		FilmDto filmDto = null;
		if (filmOptional.isPresent()) {
			filmDto = filmMapper.toFilmDto(filmOptional.get());
		}
		return Optional.ofNullable(filmDto);

	}

	@Override
	public FilmDto ajouterFilm(FilmDto filmDto) {
		return filmMapper.toFilmDto(filmRepository.save(filmMapper.toFilm(filmDto)));
	}

}
