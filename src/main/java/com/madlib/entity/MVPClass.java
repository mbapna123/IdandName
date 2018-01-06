package com.madlib.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="MVP")
public class MVPClass {
	private int id;
    private String mvp;
    private Set<Entitie> humans;

    public MVPClass(){
    }

    public MVPClass(String mvp){
        this.mvp = mvp;
    
    }
    @Id
    @GeneratedValue
    @Column(name="mvpid")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="mvp")
    public String getMVP() {
        return mvp;
    }

    public void setMVP(String mvp) {
        this.mvp = mvp;
    }
    
    @ManyToMany(mappedBy = "mvpclass",cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<Entitie> getHumans() {
        return humans;
    }

    public void setHumans(Set<Entitie> humans) {
        this.humans = humans;
    }
    
    public void addHuman(Entitie ent) {
    	
    }
    
}