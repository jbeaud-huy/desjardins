package com.example.entrevueSpringBoot.film;

import java.util.Set;

import com.example.entrevueSpringBoot.acteur.ActeurDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private String titre;

	@JsonProperty
	private String description;

	@JsonProperty
	@Exclude
	private Set<ActeurDto> acteurs;

}
