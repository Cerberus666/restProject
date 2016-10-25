package dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.RationFamilyData;
import bean.RationMasterData;

public class RationDao extends Dao{

	Session session = null;
	
	public RationDao(){
		super();
		this.session = super.session;
	}
	
	public ArrayList<RationMasterData> getRationMasterData(){
		Query query = session.createQuery("from RationMasterData");
		return (ArrayList<RationMasterData>)query.list();
	}

	public ArrayList<RationFamilyData> getFamilyDataByrationId(int rationCardId) {
		Query query = session.createQuery("from family_data_mapping where rationId=:rationid")
				.setParameter("rationid", rationCardId);
		return (ArrayList<RationFamilyData>)query.list();
	}
	
}
