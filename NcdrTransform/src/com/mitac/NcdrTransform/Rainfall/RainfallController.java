package com.mitac.NcdrTransform.Rainfall;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mitac.NcdrTransform.methods.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RainfallController {
	private String ServerUrlBase;
	private final String CreateNcdrType = "GaugeStation";
	private final String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonGaugeStation.txt";
	private final String UpdateNcdrType = "Realtime_vCWB_nGauge_1DayJSON";
	private final String UpdateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Gauge/GaugeJson.txt";
	public RainfallController(String ServerUrlBase) {
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
		String RST_DATE = GetJson.getString("Rst_date");
		JSONArray GetJsonArr = GetJson.getJSONArray(UpdateNcdrType);
		RainfallThingJson RF_json = new RainfallThingJson();
		PostMethod Post = new PostMethod();
//		System.out.println("Rainfall Update size: "+GetJsonArr.size());
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));//from ncdr
			String Stid = tmp.getString("STID");
			String Stnm = tmp.getString("STNM");
			String ThingName = "雨量站-"+Stid+"-"+Stnm;
			//System.out.println(ThingName);
			try {
				ThingName = URLEncoder.encode(ThingName,"UTF-8");
			}
			catch(UnsupportedEncodingException e) {
				e.printStackTrace();
				continue;
			}
			//System.out.println(ThingName);
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
			for(int j=0;j<tmpGetJsonArr.size();j++) {//for every datastreams, to get id
				tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(j));
				String DataStreamId = tmpJsonObj.getString("@iot.id");
				String DataStreamName = tmpJsonObj.getString("name");
				//DataStreamIdMaps.put(DataStreamId, DataStreamName);
				String PostUrl = ServerUrlBase+"/Datastreams("+DataStreamId+")/Observations";
				String DataStreamType = DataStreamName.split("-")[2];
				//System.out.println(PostUrl+", Type: "+DataStreamType);
				if(DataStreamType.equals("Hour_1")){
					RF_json.setUpdateObject(RST_DATE,tmp.getString("Hour_1"));
				}
				else if(DataStreamType.equals("Hour_3")) {
					RF_json.setUpdateObject(RST_DATE,tmp.getString("Hour_3"));
				}
				else if(DataStreamType.equals("Hour_24")){
					RF_json.setUpdateObject(RST_DATE,tmp.getString("Hour_24"));
				}
				//System.out.println(RF_json.getUpdateObject());
				Post.doJsonPost(PostUrl,RF_json.getUpdateObject());
			}
			//System.out.println(DataStreamIdMaps);
			// --- get datastream id end ---
		}
	}
	public void CreateThing() {
		GetMethod Get = new GetMethod(CreateNcdrUrl);
		JSONObject GetJson = Get.doGetJson();//Get Json from CreateNcdrUrl
		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
		//System.out.println(GetJsonArr);
//		System.out.println("Rainfall Create size: "+GetJsonArr.size());
		RainfallThingJson RF_json = new RainfallThingJson();
		PostMethod Post = new PostMethod();
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));
			RF_json.setPostThingObject(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),tmp.getString("Elev"));
			//System.out.println(Rainfall_json.getPostThingObject());
			Post.doJsonPost(ServerUrlBase+"/Things",RF_json.getPostThingObject());
		}
	}
}
