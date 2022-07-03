package com.example.entrevueSpringBoot.film;

import java.util.Optional;

/**
 * <b>Service gérant les {@link Film}
 * 
 * @author beaudhuy
 *
 */
public interface FilmService {

	/**
	 * Retourne un optional sur un film
	 * 
	 * @param id l'id du film
	 * @return vide si le film n'existe pas
	 */
	Optional<FilmDto> getFilm(Integer id);

	/**
	 * Crée un film
	 * 
	 * @param filmDto les données à persister
	 * @return le film créé
	 */
	FilmDto ajouterFilm(FilmDto filmDto);

}
