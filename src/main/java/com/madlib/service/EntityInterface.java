package com.madlib.service;

import java.util.ArrayList;
import java.util.List;

import com.madlib.entity.Entitie;

public interface EntityInterface {
	int addname(String nameo, String fingerprinto, float height, float weight);
	List<Entitie> getEntitiess();
	float getaveragearray(ArrayList<Float>arrays);
	
}
