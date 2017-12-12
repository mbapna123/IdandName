package com.madlib.dao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.madlib.entity.Entitie;
import com.madlib.entity.MovieClass;
@Transactional
@Repository
public class DatabaseConnection implements DatabaseInterface  {
	@PersistenceContext	
	private EntityManager entityManager;
	MovieClass Up=new MovieClass("Up");
	MovieClass It=new MovieClass("It");
	MovieClass Ice=new MovieClass("Ice");
//	@Override
//	public void initial() {
//		entityManager.persist(Up);
//		entityManager.persist(It);
//		entityManager.persist(Ice);
//	}
	@Override
	public void insertname(String name, String fingerprint, float height, float weight, String movie, String movie1){
		Entitie newE=new Entitie(name,fingerprint, height, weight);
		Set <MovieClass> mov=new HashSet<MovieClass>();
		if (movie.equals("Up")) {
			mov.add(Up);
		}
		if(movie.equals("It")){
			mov.add(It);
		}
		if(movie.equals("Ice")) {
			mov.add(Ice);
		}
		if(movie1.equals("Up")) {
			mov.add(Up);
		}
		if(movie1.equalsIgnoreCase("It")){
			mov.add(It);
		}
		if(movie1.equals("Ice")) {
			mov.add(Ice);
		}
		newE.setMovies(mov);
		entityManager.persist(newE);
	}

	@Override
	public List<Entitie> getEntities(){
		String hql = "FROM Entitie";
		return (List<Entitie>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public void update(int id, String name, float height, float weight, String movie, String movie1) {
		Entitie ent=entityManager.find(Entitie.class, 1);
		ent.setHeight(height);
		ent.setname(name);
		ent.setWeight(weight);
		Set<MovieClass> mov=new HashSet<MovieClass>();
		if (movie.equals("Up")) {
			mov.add(Up);
		}
		if(movie.equals("It")){
			mov.add(It);
		}
		if(movie.equals("Ice")) {
			mov.add(Ice);
		}
		if(movie1.equals("Up")) {
			mov.add(Up);
		}
		if(movie1.equalsIgnoreCase("It")){
			mov.add(It);
		}
		if(movie1.equals("Ice")) {
			mov.add(Ice);
		}
		ent.setMovies(mov);
		entityManager.merge(ent);
	}
	
	@Override
	public List<Entitie> getEntitiesFingerprint(String fingerprint){
		String hql = "FROM Entitie as ent WHERE ent.fingerprint=" +"'"+fingerprint+"'";
		return (List<Entitie>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void removenamee(String fingerprint) {
		String hql = "DELETE FROM Entitie as ent WHERE ent.fingerprint=" +"'"+fingerprint+"'";
		entityManager.createQuery(hql);
	}
	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}
}
