package com.example.entrevueSpringBoot.film;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.config.ApiConstants;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controleur APi pour la gestion des films
 * 
 * @author jbeaudhuy
 *
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = ApiConstants.PATH_API_FILMS)
public class FilmController {

	@Autowired
	private final FilmService filmService;

	/**
	 * Appel api pour charger un film
	 * 
	 * @param filmId l'id du film
	 * @see <a href=
	 *      "https://github.com/jmboyer/EntrevueSpringBoot#get-apifilmid">Modèle de
	 *      GET pour un film</a>
	 * @return 200 si le film est présent sinon 400
	 */
	@GetMapping(path = ApiConstants.PATH_API_FILM_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmDto> getFilm(@PathVariable Integer filmId) {
		if (log.isDebugEnabled()) {
			log.debug("Appel du film " + filmId);
		}
		Optional<FilmDto> filmDtoOptional = filmService.getFilm(filmId);

		if (filmDtoOptional.isPresent()) {
			return ResponseEntity.ok(filmDtoOptional.get());
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Appel Api pour la création du film
	 * 
	 * @see <a href=
	 *      "https://github.com/jmboyer/EntrevueSpringBoot#post-apifilm">Modèle de
	 *      POST pour un film</a>
	 * @param filmDto les données saisies
	 * @return 201 avec le film créé
	 */
	@PostMapping
	public ResponseEntity<Object> postCompte(@RequestBody FilmDto filmDto) {
		if (log.isDebugEnabled()) {
			log.debug("Création du film " + filmDto);
		}
		FilmDto filmDtoCree = filmService.ajouterFilm(filmDto);
		return ResponseEntity.created(URI.create(ApiConstants.PATH_API_FILMS + "/" + filmDtoCree.getId()))
				.body(filmDtoCree);
	}

}
