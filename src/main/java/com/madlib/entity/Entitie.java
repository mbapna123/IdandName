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
@Table(name="Person")
public class Entitie implements Serializable{
	
	public Entitie() {
	}
	
	public Entitie(String name, String city, String fingerprint) {
		this.name=name;
		this.fingerprint=fingerprint;
		this.city=city;
		}
	
	private static final long serialVersionUID = 1L;
	
	
    private int id;  
	
    private String fingerprint;
	
	private String name;
	
	private String city;
		
	private Set<MVPClass> mvpclass;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idperson")
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
	@Column(name="Name")
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	@Column(name="City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name = "MVPPerson",joinColumns = @JoinColumn(name = "idperson", referencedColumnName = "personid"), inverseJoinColumns = @JoinColumn(name = "mvpid", referencedColumnName = "mvpid"))
public Set<MVPClass> getMVPClass() {
	return mvpclass;
}

public void setMVPClass(Set<MVPClass> mvpclass) {
	this.mvpclass = mvpclass;
	}

}