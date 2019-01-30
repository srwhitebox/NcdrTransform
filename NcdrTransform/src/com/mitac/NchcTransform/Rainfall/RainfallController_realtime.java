package com.mitac.NchcTransform.Rainfall;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.mitac.NchcTransform.methods.*;
import com.mitac.NchcTransform.Weather.WeatherThingJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RainfallController_realtime {
	private String ServerUrlBase;
	Date date = new Date();
	
	SimpleDateFormat SDF = new SimpleDateFormat ("yyyyMMddHH00");
	private String CreateAndUpdateUrl = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0002-001?Authorization=rdec-key-123-45678-011121314";
	
	public RainfallController_realtime(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
	public RainfallController_realtime() {
		// TODO Auto-generated constructor stub
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
	public String DateFormat_yyyymmddhh (String date){
		SimpleDateFormat SDF = new SimpleDateFormat ("yyyyMMddk");
		SDF.setLenient(false);
		Date newDate = null;
		try {
			newDate = SDF.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat SDF_HH = new SimpleDateFormat("HH");
		//System.out.println(SDF.format(newDate));
		//System.out.println(Integer.parseInt(SDF_HH.format(newDate)));
		if(Integer.parseInt(SDF_HH.format(newDate)) == 0){
			String newDate_str = SDF.format(newDate);
			try {
				newDate = SDF.parse(newDate_str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar   calendar   =   new   GregorianCalendar(); 
			calendar.setTime(newDate);
			calendar.add(calendar.DATE, 1);
			newDate = calendar.getTime();
		}
		
		return SDF.format(newDate).toString();
		//return newDate.toString();
	}
	//歷史資料2017以前
	public void UpdateThing() {
		//get weather update stid array
		GetMethod Get = new GetMethod(CreateAndUpdateUrl);
		JSONObject OpenDataList = Get.doGetJson_https().getJSONObject("records");
		JSONArray GetJsonArr_Open = OpenDataList.getJSONArray("location");
		
		RainfallThingJson WHR_json = new RainfallThingJson();
		PostMethod Post = new PostMethod();
		
//		System.out.println("Weather Update size: "+(TmpList.size()-1));
		
		int ColNum=0;
		for(int i=0;i<GetJsonArr_Open.size();i++) {//TmpList.size()
			JSONObject OpenJson = (JSONObject) GetJsonArr_Open.get(i);
			if(false) {
				
			}
			else {
				if(true) {
					// add ------------------------------ start
					JSONObject tmp = new JSONObject();
					String STID = "";
					String STNM = "";
					String LAT = "";
					String LON = "";
					String CityName = "";
					String City_SN = "";
					String TownName = "";
					String Town_SN = "";
					String Attribute = "";
					JSONArray tmpArr = OpenJson.getJSONArray("parameter");
					STID = OpenJson.getString("stationId");
					STNM = OpenJson.getString("locationName");
					LAT = OpenJson.getString("lat");
					LON = OpenJson.getString("lon");
					for(int k=0;k<tmpArr.size();k++) {
						JSONObject Obj_parameter = tmpArr.getJSONObject(k);
						if(Obj_parameter.getString("parameterName").equals("CITY")) CityName=Obj_parameter.getString("parameterValue");
						if(Obj_parameter.getString("parameterName").equals("CITY_SN")) City_SN=Obj_parameter.getString("parameterValue");
						if(Obj_parameter.getString("parameterName").equals("TOWN")) TownName=Obj_parameter.getString("parameterValue");
						if(Obj_parameter.getString("parameterName").equals("TOWN_SN")) Town_SN=Obj_parameter.getString("parameterValue");
						if(Obj_parameter.getString("parameterName").equals("ATTRIBUTE")) Attribute=Obj_parameter.getString("parameterValue");
					}
//					System.out.println(STID+","+STNM+","+LAT+","+LON+","+CityName+","+City_SN+","+TownName+","+Town_SN+","+Attribute);
					tmp = new JSONObject();
					tmp.put("STID", STID);
					tmp.put("STNM", STNM);
					tmp.put("LAT", LAT);
					tmp.put("LON", LON);
					tmp.put("CityName", CityName);
					tmp.put("City_SN", City_SN);
					tmp.put("TownName", TownName);
					tmp.put("Town_SN", Town_SN);
					tmp.put("Attribute", Attribute);
					// add ------------------------------- end
					if(OpenJson.get("stationId").toString().equals(tmp.getString("STID"))) { //check again, avoid STID not found
						String Stid = tmp.getString("STID");
						String Stnm = tmp.getString("STNM");
						String ThingName = "雨量站_open-"+Stid+"-"+Stnm;
						//System.out.println(ThingName);
						try {
							ThingName = URLEncoder.encode(ThingName,"UTF-8");
						}
						catch(UnsupportedEncodingException e) {
							e.printStackTrace();
							continue;
						}
						//System.out.println(ThingName);
						//tmpSplitCol[1] = DateFormat_yyyymmddhh(tmpSplitCol[1]);
						JSONObject OpenJson_Time = (JSONObject) OpenJson.get("time");
						String RST_Date = OpenJson_Time.get("obsTime").toString().split(" ")[0]+"T"+OpenJson_Time.get("obsTime").toString().split(" ")[1];
						JSONArray obOpen = OpenJson.getJSONArray("weatherElement");
						
						String ELEV = null;
						String RAIN = null;
						String MIN_10 = null;
						String HOUR_3 = null;
						String HOUR_6 = null;

						String HOUR_12 = null;
						String HOUR_24 = null;
						String NOW = null;
						
						for(int k=0; k<obOpen.size(); k++){
							JSONObject weatherElement = (JSONObject) obOpen.get(k);
							String obData = weatherElement.getString("elementName");
							switch (obData){
							case "ELEV":
								ELEV = weatherElement.getString("elementValue");
					            break;
							case "RAIN":
								RAIN = weatherElement.getString("elementValue");
					            break;
							case "MIN_10":
								MIN_10 = weatherElement.getString("elementValue");
					            break;
							case "HOUR_3":
								HOUR_3 = weatherElement.getString("elementValue");
					            break;
							case "HOUR_6":
								HOUR_6 = weatherElement.getString("elementValue");
					            break;
							case "HOUR_12":
								HOUR_12 = weatherElement.getString("elementValue");
					            break;
							case "HOUR_24":
								HOUR_24 = weatherElement.getString("elementValue");
					            break;
							case "NOW":
								NOW = weatherElement.getString("elementValue");
					            break;
					            }
						}
						
						if(!IsThingExist(ThingName)) {  //thing is not exist, create it
							WHR_json.setPostThingObject_open(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),
									RST_Date
									,ELEV
									,RAIN
									,MIN_10
									,HOUR_3
									,HOUR_6
									,HOUR_12
									,HOUR_24
									,NOW);
							Post.doJsonPost(ServerUrlBase+"/Things",WHR_json.getPostThingObject());
						}
						else {	//thing is exist, update it
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
								if(DataStreamType.equals("ELEV")){
									WHR_json.setUpdateObject(RST_Date,ELEV);
								}
								else if(DataStreamType.equals("RAIN")) {
									WHR_json.setUpdateObject(RST_Date,RAIN);
								}
								else if(DataStreamType.equals("MIN_10")){
									WHR_json.setUpdateObject(RST_Date,MIN_10);
								}
								else if(DataStreamType.equals("HOUR_3")){
									WHR_json.setUpdateObject(RST_Date,HOUR_3);
								}
								else if(DataStreamType.equals("HOUR_6")){
									WHR_json.setUpdateObject(RST_Date,HOUR_6);
								}
								else if(DataStreamType.equals("HOUR_12")){
									WHR_json.setUpdateObject(RST_Date,HOUR_12);
								}
								else if(DataStreamType.equals("HOUR_24")){
									WHR_json.setUpdateObject(RST_Date,HOUR_24);
								}
								else if(DataStreamType.equals("NOW")){
									WHR_json.setUpdateObject(RST_Date,NOW);
								}
								//System.out.println(RF_json.getUpdateObject());
								Post.doJsonPost(PostUrl,WHR_json.getUpdateObject());
							}
							//System.out.println(DataStreamIdMaps);
							// --- get datastream id end ---
						}
					}else{
						//System.out.println("there is no sensor");
					}
				}
			}
		}
	}
//	public void CreateThing() {
//		GetMethod Get = new GetMethod(CreateAndUpdateUrl);
//		List<String> TmpList = Get.doGetStrList();
//		//System.out.println(TmpList.size());
//		
//		//--- get Station info of Rainfall start ---
//		GetMethod Get_Rain = new GetMethod(CreateNcdrUrl);
//		JSONObject GetJson = Get_Rain.doGetJson();//Get Json from CreateNcdrUrl
//		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
//		//--- get Station info of Rainfall end ---
//		
//		System.out.println("Weather Create size: "+(TmpList.size()-1));
//		WeatherThingJson WHR_json = new WeatherThingJson();
//		PostMethod Post = new PostMethod();
//		
//		int ColNum=0;
//		for(int i=0;i<2;i++) {//TmpList.size()
//			String[] tmpSplitCol = TmpList.get(i).split(",");
//			if(i==0) {
//				ColNum = tmpSplitCol.length;
//			}
//			else {
//				if(tmpSplitCol.length==ColNum) {
//					System.out.println(tmpSplitCol[0]);
//					JSONObject tmp = null;
//					for(int j=0;j<GetJsonArr.size();j++) {
//						tmp = JSONObject.fromObject(GetJsonArr.get(j));
//						if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //find it, break
//							break;
//						}
//					}
//					if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //check again, avoid STID not found
//						String RST_Date = tmpSplitCol[1].split(" ")[0]+"T"+tmpSplitCol[1].split(" ")[1];
//						String WDIR = tmpSplitCol[2];
//						String WDSD = tmpSplitCol[3];
//						String TEMP = tmpSplitCol[4];
//						String HUMD = tmpSplitCol[5];
//						String PRES = tmpSplitCol[6];
//						String SUN = tmpSplitCol[7];
//						String H_24R = tmpSplitCol[8];
//						String WS15M = tmpSplitCol[9];
//						String WD15M = tmpSplitCol[10];
//						String WS15T = tmpSplitCol[11];
//						String Elev = tmpSplitCol[14];
//						WHR_json.setPostThingObject(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),RST_Date,WDIR, WDSD, TEMP, HUMD, PRES, SUN, H_24R, Elev, WS15M, WD15M, WS15T);
//						//System.out.println(WHR_json.getPostThingObject());
//					}
//					Post.doJsonPost(ServerUrlBase+"/Things",WHR_json.getPostThingObject());
//				}
//			}
//		}
//	}
}
