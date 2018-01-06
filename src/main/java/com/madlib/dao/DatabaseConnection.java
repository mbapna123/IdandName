package com.madlib.dao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.madlib.entity.Entitie;
import com.madlib.entity.MVPClass;
@Transactional
@Repository
public class DatabaseConnection implements DatabaseInterface  {
	@PersistenceContext	
	private EntityManager entityManager;
	MVPClass James=new MVPClass("James");
	MVPClass Harden=new MVPClass("Harden");
	MVPClass Durant=new MVPClass("Durant");
//	@Override
////	public void initial() {
////		entityManager.persist(James);
////		entityManager.persist(Harden);
////		entityManager.persist(Durant);
////	}
	@Override
	public void insertname(String name, String fingerprint, String city, String mvp, String mvp2){
		Entitie newE=new Entitie(name,fingerprint,city);
		Set <Entitie> mc=new HashSet<Entitie>();
		if (mvp.equals("James")) {
			MVPClass item=entityManager.find(MVPClass.class, 1);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
		if(mvp.equals("Harden")){
			MVPClass item=entityManager.find(MVPClass.class, 2);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
		if(mvp.equals("Durant")) {
			MVPClass item=entityManager.find(MVPClass.class, 2);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
		if (mvp2.equals("James")) {
			MVPClass item=entityManager.find(MVPClass.class, 1);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
		if(mvp2.equals("Harden")){
			MVPClass item=entityManager.find(MVPClass.class, 2);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
		if(mvp2.equals("Durant")) {
			MVPClass item=entityManager.find(MVPClass.class, 2);
			Set<Entitie> mvpees=item.getHumans();
			mvpees.add(newE);
			item.setHumans(mvpees);
			entityManager.merge(item);
		}
	}

	@Override 
	public ArrayList<Integer> getinfo() {
		String hql = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=James";
		int numb=(int) entityManager.createQuery(hql).getSingleResult();
		String hql2 = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=Harden";
		int numb2=(int) entityManager.createQuery(hql2).getSingleResult();
		String hql3 = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=Harden";
		int numb3=(int) entityManager.createQuery(hql3).getSingleResult();
		ArrayList<Integer> countmvp=new ArrayList<Integer>();
		countmvp.add(numb);
		countmvp.add(numb2);
		countmvp.add(numb3);
		return countmvp;
	}
	
	@Override 
	public ArrayList<Integer> getinfocity(String city) {
		String hql = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=James && t.city='"+city+"'";
		int numb=(int) entityManager.createQuery(hql).getSingleResult();
		String hql2 = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=Harden && t.city='"+city+"'";
		int numb2=(int) entityManager.createQuery(hql2).getSingleResult();
		String hql3 = "SELECT COUNT id FROM MVPClass d join d.humans t where d.mvp=Harden && t.city='"+city+"'";;
		int numb3=(int) entityManager.createQuery(hql3).getSingleResult();
		ArrayList<Integer> countmvpcity=new ArrayList<Integer>();
		countmvpcity.add(numb);
		countmvpcity.add(numb2);
		countmvpcity.add(numb3);
		return countmvpcity;
	}
	@Override
	public List<Entitie> getEntities(){
		String hql = "FROM Entitie";
		return (List<Entitie>) entityManager.createQuery(hql).getResultList();
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
}
