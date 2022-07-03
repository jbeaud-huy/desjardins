package com.example.entrevueSpringBoot.film;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.entrevueSpringBoot.acteur.Acteur;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

/**
 * Un film peut avoir plusieurs {@link Acteur}
 * 
 * @author jbeaudhuy
 *
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue
	@Column(name = "film_id", nullable = false, length = 8)
	private Integer id;

	/**
	 * Le titre du film
	 */
	@Column(name = "nom", nullable = false, length = 250)
	@Exclude
	private String titre;

	/**
	 * La description du film
	 */
	@Column(name = "description", nullable = false, length = 250)
	@Exclude
	private String description;

	/**
	 * La liste des acteurs ayant joué dans le film
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "film_acteur", joinColumns = { @JoinColumn(name = "acteur_id") }, inverseJoinColumns = {
			@JoinColumn(name = "film_id") })
	@Exclude
	Set<Acteur> acteurs = new HashSet<Acteur>();
}
