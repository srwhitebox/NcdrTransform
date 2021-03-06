package com.mitac.NchcTransform.Weather;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.mitac.NchcTransform.methods.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeatherController_realtime {
	private String ServerUrlBase;
	Date date = new Date();
	
	SimpleDateFormat SDF = new SimpleDateFormat ("yyyyMMddHH00");
	private String CreateAndUpdateUrl = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0001-001?Authorization=rdec-key-123-45678-011121314";
	
	public WeatherController_realtime(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
	public WeatherController_realtime() {
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
		
		WeatherThingJson WHR_json = new WeatherThingJson();
		PostMethod Post = new PostMethod();
		
//		System.out.println("Weather Update size: "+(TmpList.size()-1));
		
		int ColNum=0;
		for(int i=0;i<GetJsonArr_Open.size();i++) {//TmpList.size()
			JSONObject OpenJson = (JSONObject) GetJsonArr_Open.get(i);
			if(false) {
				
			}
			else {
				if(true) {
//					JSONObject tmp = null;
//					for(int j=0;j<GetJsonArr.size();j++) {
//						tmp = JSONObject.fromObject(GetJsonArr.get(j));
//						if(OpenJson.get("stationId").toString().equals(tmp.getString("STID"))) { //find it, break
//							break;
//						}
//					}
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
						String ThingName = "氣象站_open-"+Stid+"-"+Stnm;
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
						String WDIR = null;
						String WDSD = null;
						String TEMP = null;
						String HUMD = null;
						String PRES = null;
						String SUN = null;
						String H_24RNA = null;
						String H_FX = null;
						String H_XD = null;
						String H_FXT = null;
						String D_TX = null;
						String D_TXT = null;
						String D_TN = null;
						String D_TNT = null;
						
						for(int k=0; k<obOpen.size(); k++){
							JSONObject weatherElement = (JSONObject) obOpen.get(k);
							String obData = weatherElement.getString("elementName");
							switch (obData){
							case "ELEV":
								ELEV = weatherElement.getString("elementValue");
					            break;
							case "WDIR":
								WDIR = weatherElement.getString("elementValue");
					            break;
							case "WDSD":
								WDSD = weatherElement.getString("elementValue");
					            break;
							case "TEMP":
								TEMP = weatherElement.getString("elementValue");
					            break;
							case "HUMD":
								HUMD = weatherElement.getString("elementValue");
					            break;
							case "PRES":
								PRES = weatherElement.getString("elementValue");
					            break;
							case "SUN":
								SUN = weatherElement.getString("elementValue");
					            break;
							case "H_24RNA":
								H_24RNA = weatherElement.getString("elementValue");
					            break;
							case "H_FX":
								H_FX = weatherElement.getString("elementValue");
					            break;
							case "H_XD":
								H_XD = weatherElement.getString("elementValue");
					            break;
							case "H_FXT":
								H_FXT = weatherElement.getString("elementValue");
					            break;
							case "D_TX":
								D_TX = weatherElement.getString("elementValue");
					            break;
							case "D_TXT":
								D_TXT = weatherElement.getString("elementValue");
					            break;
							case "D_TN":
								D_TN = weatherElement.getString("elementValue");
					            break;
							case "D_TNT":
								D_TNT = weatherElement.getString("elementValue");
					            break;
					            }
						}
						
						if(!IsThingExist(ThingName)) {  //thing is not exist, create it
							WHR_json.setPostThingObject_open(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),
									RST_Date
									,ELEV
									,WDIR
									,WDSD
									,TEMP
									,HUMD
									,PRES
									,SUN
									,H_24RNA
									,H_FX
									,H_XD
									,H_FXT
									,D_TX
									,D_TXT
									,D_TN
									,D_TNT);
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
								else if(DataStreamType.equals("WDIR")) {
									WHR_json.setUpdateObject(RST_Date,WDIR);
								}
								else if(DataStreamType.equals("WDSD")){
									WHR_json.setUpdateObject(RST_Date,WDSD);
								}
								else if(DataStreamType.equals("TEMP")){
									WHR_json.setUpdateObject(RST_Date,TEMP);
								}
								else if(DataStreamType.equals("HUMD")){
									WHR_json.setUpdateObject(RST_Date,HUMD);
								}
								else if(DataStreamType.equals("PRES")){
									WHR_json.setUpdateObject(RST_Date,PRES);
								}
								else if(DataStreamType.equals("SUN")){
									WHR_json.setUpdateObject(RST_Date,SUN);
								}
								else if(DataStreamType.equals("H_24RNA")){
									WHR_json.setUpdateObject(RST_Date,H_24RNA);
								}
								else if(DataStreamType.equals("H_FX")){
									WHR_json.setUpdateObject(RST_Date,H_FX);
								}
								else if(DataStreamType.equals("H_XD")){
									WHR_json.setUpdateObject(RST_Date,H_XD);
								}
								else if(DataStreamType.equals("H_FXT")){
									WHR_json.setUpdateObject(RST_Date,H_FXT);
								}
								else if(DataStreamType.equals("D_TX")){
									WHR_json.setUpdateObject(RST_Date,D_TX);
								}
								else if(DataStreamType.equals("D_TXT")){
									WHR_json.setUpdateObject(RST_Date,D_TXT);
								}
								else if(DataStreamType.equals("D_TN")){
									WHR_json.setUpdateObject(RST_Date,D_TN);
								}
								else if(DataStreamType.equals("D_TNT")){
									WHR_json.setUpdateObject(RST_Date,D_TNT);
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
