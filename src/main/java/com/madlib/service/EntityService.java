package com.madlib.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.madlib.dao.DatabaseInterface;
import com.madlib.entity.Entitie;
import com.madlib.entity.MVPClass;
import com.mysql.fabric.xmlrpc.base.Array;
@Service
public class EntityService implements EntityInterface {
	
	private ArrayList<Float> heightarray=new ArrayList<Float>();
	private ArrayList<Float> weightarray=new ArrayList<Float>();
	private ArrayList<Float[]> heightweight=new ArrayList<Float[]>();
	@Autowired
	private DatabaseInterface DaInterface;
	
	@Override
	public void initialize() {
		DaInterface.initial();
	}
	
	@Override
	public void removethename(String ids) {
		DaInterface.removenamee(ids);
	}
	@Override
	public int addname(String nameo, String fingerprinto, String city, String mvp, String mvp2){
		List<Entitie> fingerlist=DaInterface.getEntitiesFingerprint(fingerprinto);
		int numberfingerent=fingerlist.size();
		if (numberfingerent==1) {
			return 0;
		}
		else{
			DaInterface.insertname(nameo, fingerprinto, city, mvp, mvp2);
			return 1;
		}
	}
	
	@Override
	public List<Entitie> getEntitiess(){
		return DaInterface.getEntities();
	}


	@Override
	public ArrayList<Integer> infocity(String city) {
		return DaInterface.getinfocity(city);
	}

	@Override
	public ArrayList<Integer> info() {
		return DaInterface.getinfo();
	}
}