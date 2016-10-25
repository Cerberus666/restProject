package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bean.RationFamilyData;
import bean.RationMasterData;
import dao.RationDao;

@Path("/RationService")
public class RationService {
	
	@GET
	@Path("/{param}")
	public Response invalidRequestGET(@PathParam("param") String uri){
		return Response.status(200)
				.entity("invalid request " + uri)
				.build();
	}
	
	@POST
	@Path("/{param}")
	public Response invalidRequestPOST(@PathParam("param") String uri){
		return Response.status(200)
				.entity("invalid request " + uri)
				.build();
	}
	
	@GET
	@Path("/fullRationData")
	public Response getFullRationData1(){
		return Response.status(200).entity("inside rest service").build();
	}
	
	@GET
	@Path("/fullRationData1")
	public Response getFullRationData(){
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
		return Response.status(200).entity(rationArray).build();
	}

}
