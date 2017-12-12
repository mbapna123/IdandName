package com.madlib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.madlib.entity.Entitie;
import com.madlib.entity.MovieClass;

public interface EntityInterface {
	void removethename(String ids);
	void initialize();
	int addname(String nameo, String fingerprinto, float height, float weight, String movie, String movie1);
	List<Entitie> getEntitiess();
	float getaveragearray(ArrayList<Float>arrays);
}
