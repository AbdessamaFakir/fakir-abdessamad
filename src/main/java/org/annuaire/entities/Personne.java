package org.annuaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Personne implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String bureau;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getBureau() {
		return bureau;
	}
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
	public Personne(String nom, String bureau) {
		super();
		this.nom = nom;
		this.bureau = bureau;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
