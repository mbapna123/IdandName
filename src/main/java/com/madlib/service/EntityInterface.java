package com.madlib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.madlib.entity.Entitie;

public interface EntityInterface {
	void removethename(String ids);
	ArrayList<Integer> infocity(String city);
	ArrayList<Integer> info();
	void initialize();
	 int addname(String nameo, String fingerprinto, String age, String mvp, String mvp2);
	List<Entitie> getEntitiess();
}
