package com.madlib.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.madlib.entity.Entitie;
public interface DatabaseInterface {
	void removenamee(String fingerprint);
	void initial();
	List<Entitie> getEntities();
	List<Entitie> getEntitiesFingerprint(String fingerprint);
	ArrayList<Integer> getinfo();
	ArrayList<Integer> getinfocity(String city);
	void insertname(String nameo, String fingerprinto, String city, String mvp, String mvp2);
}
