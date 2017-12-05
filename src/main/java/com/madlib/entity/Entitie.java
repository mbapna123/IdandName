package com.madlib.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="idtable3")
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
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	@Column(name="fingerprint")
    private String fingerprint;
	@Column(name="name")	
	private String name;
	@Column(name="height")	
	private float height;
	@Column(name="weight")	
	private float weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfingerprint() {
		return fingerprint;
	}
	public void setPokemon(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public String getname() {
		return name;
	}
	public void setCategory(String name) {
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
}
