package com.madlib.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.madlib.dao.DatabaseInterface;
import com.madlib.entity.Entitie;
@Service
public class EntityService implements EntityInterface {
	@Autowired
	private DatabaseInterface DaInterface;

	@Override
	public int addname(String nameo, String fingerprinto){
		List<Entitie> fingerlist=DaInterface.getEntitiesFingerprint(fingerprinto);
		int numberfingerent=fingerlist.size();
		if (numberfingerent==1) {
			return 0;
		}
		else{
			DaInterface.insertname(nameo, fingerprinto);
			return 1;
		}
	}
	
	@Override
	public List<Entitie> getEntitiess(){
		return DaInterface.getEntities();
	}
}