package com.mitac.NcdrTransform.WaterLevel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mitac.NcdrTransform.methods.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WaterLevelController {
	private String ServerUrlBase;
	private final String CreateNcdrType = "WLStation";
	private final String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonWLStation.txt";
	private final String UpdateNcdrType = "Realtime_vWRA_nWaterLevelJson";
	private final String UpdateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/WaterLevel/WLJson.txt";
	public WaterLevelController(String ServerUrlBase) {
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
		WaterLevelThingJson WL_json = new WaterLevelThingJson();
		PostMethod Post = new PostMethod();
//		System.out.println("WaterLevel Update size: "+GetJsonArr.size());
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));//from ncdr
			String Stid = tmp.getString("STID");
			String Stnm = tmp.getString("STNM");
			String ThingName = "水位站-"+Stid+"-"+Stnm;
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
			WL_json.setUpdateObject(RST_DATE,tmp.getString("Stage"));
			//System.out.println(WL_json.getUpdateObject());
			Post.doJsonPost(PostUrl,WL_json.getUpdateObject());
		}
	}
	public void CreateThing() {
		GetMethod Get = new GetMethod(CreateNcdrUrl);
		JSONObject GetJson = Get.doGetJson();//Get Json from CreateNcdrUrl
		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
		//System.out.println(GetJsonArr);
//		System.out.println("WaterLevel Create size: "+GetJsonArr.size());
		WaterLevelThingJson WL_json = new WaterLevelThingJson();
		PostMethod Post = new PostMethod();
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));
			WL_json.setPostThingObject(tmp.getString("ST_NO"), tmp.getString("NAME_C"), tmp.getString("BASIN_NO"), tmp.getString("ADDR_C"), tmp.getString("WarningLine1"), tmp.getString("WarningLine2"), tmp.getString("WarningLine3"), tmp.getString("PlanFloodLine"), tmp.getString("TopLine"), tmp.getString("BottomLine"), tmp.getString("nWGS84_Lon"), tmp.getString("nWGS84_Lat"), tmp.getString("Attribute"));
			//System.out.println(WL_json.getPostThingObject());
			if(tmp.getString("nWGS84_Lon").equals("null")||tmp.getString("nWGS84_Lat").equals("null")) {
				continue;
			}
			Post.doJsonPost(ServerUrlBase+"/Things",WL_json.getPostThingObject());
		}
	}
}
