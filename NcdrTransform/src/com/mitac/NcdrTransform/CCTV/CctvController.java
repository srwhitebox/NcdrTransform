package com.mitac.NcdrTransform.CCTV;

//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;

import com.mitac.NcdrTransform.methods.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CctvController {
	private String ServerUrlBase;
	private final String CreateNcdrType = "CCTVStation";
	private final String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonCCTVStation.txt";
	//private final String UpdateNcdrType = "Realtime_vWRA_nWaterLevelJson";
	//private final String UpdateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/WaterLevel/WLJson.txt";
	public CctvController(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
//	private boolean IsThingExist(String ThingName) {
//		String Url = ServerUrlBase+"/Things?$filter=name%20eq%20%27"+ThingName+"%27";
//		GetMethod Get = new GetMethod(Url);
//		JSONArray GetJsonArr = Get.doGetJson().getJSONArray("value");
//		if(GetJsonArr.isEmpty()) {
//			return false;
//		}
//		else {
//			return true;
//		}
//	}
//	public void UpdateThing() {
//		GetMethod Get = new GetMethod(UpdateNcdrUrl);
//		JSONObject GetJson = Get.doGetJson();//Get Json from UpdateNcdrUrl
//		String RST_DATE = GetJson.getString("RST_DATE");
//		JSONArray GetJsonArr = GetJson.getJSONArray(UpdateNcdrType);
//		CctvThingJson WL_json = new CctvThingJson();
//		PostMethod Post = new PostMethod();
//		System.out.println("Update size: "+GetJsonArr.size());
//		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
//			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));//from ncdr
//			String Stid = tmp.getString("STID");
//			String Stnm = tmp.getString("STNM");
//			String ThingName = "水位站-"+Stid+"-"+Stnm;
//			//System.out.println(ThingName);
//			try {
//				ThingName = URLEncoder.encode(ThingName,"UTF-8");
//			}
//			catch(UnsupportedEncodingException e) {
//				e.printStackTrace();
//				continue;
//			}
//			if(!IsThingExist(ThingName)) {
//				continue;
//			}
//			// --- get datastream id start ---
//			String Url = ServerUrlBase+"/Things?$filter=name%20eq%20%27"+ThingName+"%27&$expand=Datastreams";
//			GetMethod Get2 = new GetMethod(Url);
//			JSONArray tmpGetJsonArr = Get2.doGetJson().getJSONArray("value");//get all info
//			//System.out.println(tmpGetJsonArr);
//			JSONObject tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(0));//get thing
//			tmpGetJsonArr = tmpJsonObj.getJSONArray("Datastreams");
//			tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(0));//get datastream
//			String DataStreamId = tmpJsonObj.getString("@iot.id");//get datastream id
//			//System.out.println("id: "+DataStreamId);
//			// --- get datastream id end ---
//			
//			String PostUrl = ServerUrlBase+"/Datastreams("+DataStreamId+")/Observations";
//			//System.out.println(RST_DATE+", "+tmp.getString("Stage"));
//			WL_json.setUpdateObject(RST_DATE,tmp.getString("Stage"));
//			//System.out.println(WL_json.getUpdateObject());
//			Post.doJsonPost(PostUrl,WL_json.getUpdateObject());
//		}
//	}
	private String CutRN(String s) {
		boolean errFormat = false;
		if((s.charAt(s.length()-2)=='\r')&&(s.charAt(s.length()-1)=='\n')) {
			errFormat = true;
		}
		if(errFormat) {
			s = s.substring(0, s.length()-2);
		}
		return s;
	}
	public void CreateThing() {
		GetMethod Get = new GetMethod(CreateNcdrUrl);
		JSONObject GetJson = Get.doGetJson();//Get Json from CreateNcdrUrl
		String UpdateDate = GetJson.getString("Update_date");//get yyyy/mm/dd
		String[] DateArr = UpdateDate.split("/");//iso 8601 => 2018-09-13T09:50:00.000Z
		UpdateDate = new String(DateArr[0]+"-"+DateArr[1]+"-"+DateArr[2]+"T00:00:00.000Z");
		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
		//System.out.println(GetJsonArr);
		//System.out.println("CCTV Create size: "+GetJsonArr.size());
		CctvThingJson CCTV_json = new CctvThingJson();
		PostMethod Post = new PostMethod();
		for(int i=0;i<GetJsonArr.size();i++) {//GetJsonArr.size()
			JSONObject tmp = JSONObject.fromObject(GetJsonArr.get(i));
			CCTV_json.setPostThingObject(tmp.getString("STID"),CutRN(tmp.getString("Location")),CutRN(tmp.getString("URL")),tmp.getString("WGS84_Lon"),tmp.getString("WGS84_Lat"),UpdateDate);
			//System.out.println(CCTV_json.getPostThingObject());
			Post.doJsonPost(ServerUrlBase+"/Things",CCTV_json.getPostThingObject());
		}
	}
}
