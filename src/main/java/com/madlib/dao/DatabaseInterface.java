package com.madlib.dao;
import java.util.List;
import com.madlib.entity.Entitie;
public interface DatabaseInterface {
	void insertname(String name, String fingerprint);
	List<Entitie> getEntities();
	List<Entitie> getEntitiesFingerprint(String fingerprint);
}
