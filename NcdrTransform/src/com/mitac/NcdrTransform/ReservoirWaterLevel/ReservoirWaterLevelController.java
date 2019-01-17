package com.mitac.NcdrTransform.ReservoirWaterLevel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mitac.NcdrTransform.methods.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReservoirWaterLevelController {
	private String ServerUrlBase;
	private final String CreateNcdrType = "ReservoirStation";
	private final String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonReservoirStation.txt";
	private final String UpdateNcdrType = "Realtime_vWRA_nReservoirBasicInfoJSON";
	private final String UpdateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/ReservoirWL/ReservoirJson.txt";
	public ReservoirWaterLevelController(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
	private boolean IsThingExist(String ThingName) {
		String Url = ServerUrlBase+"/Things?$filter=name%20eq%20%27"+ThingName+"%27";
		GetMethod Get = new GetMethod(Url);
		JSONArray GetJsonArr = Get.doGetJson().getJSONArray("value");
		if(GetJsonArr.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
	public void UpdateThing() {
		GetMethod Get = new GetMethod(UpdateNcdrUrl);
		JSONObject GetJson = Get.doGetJson();//Get Json from UpdateNcdrUrl
		String RST_DATE = GetJson.getString("RST_DATE");
		JSONArray GetJsonArr = GetJson.getJSONArray(UpdateNcdrType);
		ReservoirWaterLevelThingJson RWL_json = new ReservoirWaterLevelThingJson();
		PostMethod Post = new PostMethod();
//		System.out.println("Reservoir WaterLevel Update size: "+GetJsonArr.size());
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));//from ncdr
			String Stid = tmp.getString("STID");
			String Stnm = tmp.getString("STNM");
			String ThingName = "¤ô¦ì¯¸-"+Stid+"-"+Stnm;
			//System.out.println(ThingName);
			try {
				ThingName = URLEncoder.encode(ThingName,"UTF-8");
			}
			catch(UnsupportedEncodingException e) {
				e.printStackTrace();
				continue;
			}
			if(!IsThingExist(ThingName)) {
				continue;
			}
			// --- get datastream id start ---
			String Url = ServerUrlBase+"/Things?$filter=name%20eq%20%27"+ThingName+"%27&$expand=Datastreams";
			GetMethod Get2 = new GetMethod(Url);
			JSONArray tmpGetJsonArr = Get2.doGetJson().getJSONArray("value");//get all info
			//System.out.println(tmpGetJsonArr);
			JSONObject tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(0));//get thing
			tmpGetJsonArr = tmpJsonObj.getJSONArray("Datastreams");
			tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(0));//get datastream
			String DataStreamId = tmpJsonObj.getString("@iot.id");//get datastream id
			//System.out.println("id: "+DataStreamId);
			// --- get datastream id end ---
			
			String PostUrl = ServerUrlBase+"/Datastreams("+DataStreamId+")/Observations";
			//System.out.println(RST_DATE+", "+tmp.getString("Stage"));
			RWL_json.setUpdateObject(RST_DATE,tmp.getString("WaterLine"));
			//System.out.println(WL_json.getUpdateObject());
			Post.doJsonPost(PostUrl,RWL_json.getUpdateObject());
		}
	}
	public void CreateThing() {
		GetMethod Get = new GetMethod(CreateNcdrUrl);
		JSONObject GetJson = Get.doGetJson();//Get Json from CreateNcdrUrl
		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
		//System.out.println(GetJsonArr);
//		System.out.println("Reservoir WaterLevel Create size: "+GetJsonArr.size());
		ReservoirWaterLevelThingJson RWL_json = new ReservoirWaterLevelThingJson();
		PostMethod Post = new PostMethod();
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));
			RWL_json.setPostThingObject(tmp.getString("ST_NO"),tmp.getString("RES_NAME"),tmp.getString("BASIN_NO"),tmp.getString("RV_NAME"),tmp.getString("CAPACITY_E"),tmp.getString("NWL_MX"),tmp.getString("DWL"),tmp.getString("Enabled"),tmp.getString("Capacity_T"),tmp.getString("HydraulicStructure"),tmp.getString("FloodPrevention"),tmp.getString("Importance"),tmp.getString("Upload"),tmp.getString("KeyInIrrigate"),tmp.getString("KeyInPublic"),tmp.getString("KeyInIndustial"),tmp.getString("KeyInElectric"),tmp.getString("KeyInFlood"),tmp.getString("Note"),tmp.getString("WriteDateTime"),tmp.getString("WGS84_Lon"),tmp.getString("WGS84_Lat"));
			//System.out.println(RWL_json.getPostThingObject());
			Post.doJsonPost(ServerUrlBase+"/Things",RWL_json.getPostThingObject());
		}
	}
}
