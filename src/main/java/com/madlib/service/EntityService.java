package com.madlib.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.madlib.dao.DatabaseInterface;
import com.madlib.entity.Entitie;
import com.mysql.fabric.xmlrpc.base.Array;
@Service
public class EntityService implements EntityInterface {
	
	private ArrayList<Float> heightarray=new ArrayList<Float>();
	private ArrayList<Float> weightarray=new ArrayList<Float>();
	private ArrayList<Float[]> heightweight=new ArrayList<Float[]>();
	@Autowired
	private DatabaseInterface DaInterface;
	
	
	@Override
	public int addname(String nameo, String fingerprinto, float height, float weight){
		List<Entitie> fingerlist=DaInterface.getEntitiesFingerprint(fingerprinto);
		int numberfingerent=fingerlist.size();
		if (numberfingerent==1) {
			return 0;
		}
		else{
			DaInterface.insertname(nameo, fingerprinto, height, weight);
			heightarray.add(height);
			weightarray.add(weight);
			Float[] arr= {height,weight};
			heightweight.add(arr);
			return 1;
		}
	}
	
	@Override
	public List<Entitie> getEntitiess(){
		return DaInterface.getEntities();
	}
	public ArrayList<Float> getHeightArray(){
		return heightarray;
	}
	
	public ArrayList<Float[]> getHeightWeight(){
		return heightweight;
	}
	
	public ArrayList<Float> getWeightArray(){
		return weightarray;
	}

	@Override
public float getaveragearray(ArrayList<Float>arrays) {
	float sum=0;
	 for (Float mark : arrays) {
	        sum += mark;
	    }
	 float avg=sum/arrays.size();
	 return avg;
}

}