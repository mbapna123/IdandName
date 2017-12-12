package com.madlib.entity;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="idtaa")
public class Entitie implements Serializable{
	
	public Entitie() {
	}
	
	public Entitie(String name,String fingerprint, float height, float weight) {
		this.name=name;
		this.fingerprint=fingerprint;
		this.height=height;
		this.weight=weight;
		}
	
	private static final long serialVersionUID = 1L;
	
	
    private int id;  
	
    private String fingerprint;
	
	private String name;
	
	private float height;
		
	private float weight;
	
	private Set<MovieClass> movies;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getfingerprint() {
		return fingerprint;
	}
	
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public float getheight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getweight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movieha",joinColumns = @JoinColumn(name = "human_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
public Set<MovieClass> getMovies() {
	return movies;
}

public void setMovies(Set<MovieClass> movies) {
	this.movies = movies;
	}
}
