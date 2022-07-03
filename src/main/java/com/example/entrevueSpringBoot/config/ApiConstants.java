package com.example.entrevueSpringBoot.config;

public class ApiConstants {

	private ApiConstants() {
	}

	public static final String PATH_API = "/api";

	/**
	 * Films
	 */
	public static final String PATH_API_FILMS = PATH_API + "/film";
	public static final String PATH_API_FILM_ID = "/{filmId}";

}
