package service;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bean.RationFamilyData;
import bean.RationMasterData;
import dao.RationDao;

@Path("/ration")
public class RationService {
	
	@POST
	@Path("/fullRationData")
	public JSONArray getFullRationData(){
		JSONArray rationArray = new JSONArray();
		RationDao rationDao = new RationDao();
		ArrayList<RationMasterData> rationMasterList = rationDao.getRationMasterData();
		for(RationMasterData rationMaster : rationMasterList){
			ArrayList<RationFamilyData> familyDataList = rationDao.getFamilyDataByrationId(rationMaster.getRationCardId());
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("rationCardId", rationMaster.getRationCardId());
			jsonObj.put("holderName", rationMaster.getHolderName());
			jsonObj.put("holderAge", rationMaster.getHolderAge());
			jsonObj.put("holderGender", rationMaster.getHolderGender());
			jsonObj.put("holderAddress", rationMaster.getHolderAddress());
			jsonObj.put("ardCode", rationMaster.getArdCode());
			JSONArray familyArray = new JSONArray();
			for(RationFamilyData family : familyDataList){
				JSONObject jsonObjNew = new JSONObject();
				jsonObjNew.put("familyId", family.getFamilyId());
				jsonObjNew.put("familyName", family.getFamilyName());
				jsonObjNew.put("familyAge", family.getFamilyAge());
				jsonObjNew.put("familyGender", family.getFamilyGender());
				familyArray.add(jsonObjNew);
			}
			jsonObj.put("family", familyArray);
			rationArray.add(jsonObj);
		}
		System.out.println("ration Data : - \n" + rationArray.toString());
		return rationArray;
	}

}
