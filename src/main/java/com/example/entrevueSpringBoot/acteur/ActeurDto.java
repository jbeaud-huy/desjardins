package com.example.entrevueSpringBoot.acteur;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActeurDto {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nom")
	private String nom;

	@JsonProperty("prenom")
	private String prenom;

}
