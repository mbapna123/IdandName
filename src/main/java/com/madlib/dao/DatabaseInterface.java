package com.madlib.dao;
import java.util.List;
import java.util.Set;

import com.madlib.entity.Entitie;
import com.madlib.entity.MovieClass;
public interface DatabaseInterface {
	void removenamee(String fingerprint);
	void initial();
	void insertname(String name, String fingerprint, float height, float weight, String movie, String movie1);
	List<Entitie> getEntities();
	List<Entitie> getEntitiesFingerprint(String fingerprint);
	void update(int id, String name, float height, float weight, String movie, String movie2);
}
