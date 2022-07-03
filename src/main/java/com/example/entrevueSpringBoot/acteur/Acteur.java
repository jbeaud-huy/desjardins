package com.example.entrevueSpringBoot.acteur;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.entrevueSpringBoot.film.Film;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

/**
 * Un acteur peut jouer dans plusieurs {@link Film}
 * 
 * @author jbeaudhuy
 *
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "acteur")
public class Acteur {

	/**
	 * L'id en base (générée automatiquement)
	 */
	@Id
	@GeneratedValue
	@Column(name = "acteur_id", nullable = false, length = 8)
	private Integer id;

	/**
	 * Le nom de l'acteur
	 */
	@Column(name = "nom", nullable = false, length = 250)
	private String nom;

	/**
	 * Le prénom de l'acteur
	 */
	@Column(name = "prenom", nullable = false, length = 250)
	private String prenom;

	/**
	 * Liste des films de l'acteur
	 */
	@ManyToMany(mappedBy = "acteurs")
	@Exclude
	private Set<Film> films = new HashSet<Film>();

}
