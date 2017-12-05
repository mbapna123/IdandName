package com.madlib.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.madlib.entity.Entitie;
@Transactional
@Repository
public class DatabaseConnection implements DatabaseInterface  {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public void insertname(String name, String fingerprint) {
		Entitie newE=new Entitie(name,fingerprint);
		entityManager.persist(newE);
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
}
