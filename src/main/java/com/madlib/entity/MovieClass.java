package com.madlib.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="movia")
public class MovieClass {
	private int id;
    private String name;
    private Set<Entitie> humans;

    public MovieClass(){
    }

    public MovieClass(String name){
        this.name = name;
    }
    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="movie")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @ManyToMany(mappedBy = "movies")
    public Set<Entitie> getHumans() {
        return humans;
    }

    public void setHumans(Set<Entitie> humans) {
        this.humans = humans;
    }
    
    
}