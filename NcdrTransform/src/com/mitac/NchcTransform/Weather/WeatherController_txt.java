package com.mitac.NchcTransform.Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

public class WeatherController_txt {
	private String ServerUrlBase;
	private final String CreateNcdrType = "GaugeStation";
	private final String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonGaugeStation.txt";
//	private final String UpdateNcdrType = "Realtime_vCWB_nGauge_1DayJSON";
//	private final String UpdateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Gauge/GaugeJson.txt";
	Date date = new Date();
	
	SimpleDateFormat SDF = new SimpleDateFormat ("yyyyMMddHH00");
	private String CreateAndUpdateUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/QPESUMS/AST_LST/AST_"+SDF.format(date)+".csv";
//	private String CreateAndUpdateUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/QPESUMS/AST_LST/AST_201809260800.csv";
	
	public WeatherController_txt(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
	public WeatherController_txt() {
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
	public void UpdateThing(String path) {
		//get weather update stid array
//		GetMethod Get = new GetMethod(CreateAndUpdateUrl);
//		List<String> TmpList = Get.doGetStrList_2(path);
		
		//--- get rainfall station info start ---
		GetMethod GetRain = new GetMethod(CreateNcdrUrl);
		JSONObject GetJson = GetRain.doGetJson();//Get Json from UpdateNcdrUrl
//		String RST_DATE = GetJson.getString("Rst_date");
		JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
		//--- get rainfall station info end ---
		
		WeatherThingJson WHR_json = new WeatherThingJson();
		PostMethod Post = new PostMethod();
		
//		System.out.println("Weather Update size: "+(TmpList.size()-1));
		
		int ColNum=0;
		// --- add start
		// --- add start
		try {
			String CurrentLine;
			boolean Filter_data = false;
			//int i = 0;
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			boolean firstLine = true;
			while ((CurrentLine = br.readLine()) != null) {
				if(CurrentLine.contains("# stno")){
					Filter_data = true;
				}
				if(Filter_data == true){
					String[] CurrentLineArr = CurrentLine.split(" ");////////
					String TmpStr="";
					for(String s:CurrentLineArr) {
						if(!s.equals("")&&!s.equals("#")) {
							TmpStr+=s+",";
						}
					}
					TmpStr=TmpStr.substring(0, TmpStr.length()-1);
					String[] tmpSplitCol = TmpStr.split(",");
					if(firstLine) {
						ColNum = tmpSplitCol.length;
						firstLine=false;
					}
					else {
						if(tmpSplitCol.length==ColNum) {
							JSONObject tmp = null;
							for(int j=0;j<GetJsonArr.size();j++) {
								tmp = JSONObject.fromObject(GetJsonArr.get(j));
								if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //find it, break
									break;
								}
							}
							if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //check again, avoid STID not found
								String Stid = tmp.getString("STID");
								String Stnm = tmp.getString("STNM");
								String ThingName = "氣象站_old-"+Stid+"-"+Stnm;
								String ThingName2 = "氣象站_old-"+Stid+"-"+Stnm;
								try {
									ThingName = URLEncoder.encode(ThingName,"UTF-8");
								}
								catch(UnsupportedEncodingException e) {
									e.printStackTrace();
									continue;
								}
								//System.out.println(ThingName);
								tmpSplitCol[1] = DateFormat_yyyymmddhh(tmpSplitCol[1]);
								String RST_Date = tmpSplitCol[1].split(" ")[0]+"T"+tmpSplitCol[1].split(" ")[1];
								String PS01 = tmpSplitCol[2];
								String TX01 = tmpSplitCol[3];
								String RH01 = tmpSplitCol[4];
								String WD01 = tmpSplitCol[5];
								String WD02 = tmpSplitCol[6];
								String SS01 = tmpSplitCol[7];
								if(!IsThingExist(ThingName)) {  //thing is not exist, create it
									WHR_json.setPostThingObject_txt(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),RST_Date,PS01,TX01,RH01,WD01,WD02,SS01);
									Post.doJsonPost(ServerUrlBase+"/Things",WHR_json.getPostThingObject_txt());
//									System.out.println("create "+ThingName2);
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
										if(DataStreamType.equals("PS01")){
											WHR_json.setUpdateObject(RST_Date,PS01);
										}
										else if(DataStreamType.equals("TX01")) {
											WHR_json.setUpdateObject(RST_Date,TX01);
										}
										else if(DataStreamType.equals("RH01")){
											WHR_json.setUpdateObject(RST_Date,RH01);
										}
										else if(DataStreamType.equals("WD01")){
											WHR_json.setUpdateObject(RST_Date,WD01);
										}
										else if(DataStreamType.equals("WD02")){
											WHR_json.setUpdateObject(RST_Date,WD02);
										}
										else if(DataStreamType.equals("SS01")){
											WHR_json.setUpdateObject(RST_Date,SS01);
										}
										Post.doJsonPost(PostUrl,WHR_json.getUpdateObject());
									}
//									System.out.println("update "+ThingName2);
								}
							}
						}
					}
				}
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		// --- add end
//		for(int i=0;i<TmpList.size();i++) {//TmpList.size()
//			String[] tmpSplitCol = TmpList.get(i).split(",");
//			if(i==0) {
//				ColNum = tmpSplitCol.length;
//			}
//			else {
//				if(tmpSplitCol.length==ColNum) {
//					JSONObject tmp = null;
//					for(int j=0;j<GetJsonArr.size();j++) {
//						tmp = JSONObject.fromObject(GetJsonArr.get(j));
//						if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //find it, break
//							break;
//						}
//					}
//					if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //check again, avoid STID not found
//						String Stid = tmp.getString("STID");
//						String Stnm = tmp.getString("STNM");
//						String ThingName = "氣象站_old-"+Stid+"-"+Stnm;
//						//System.out.println(ThingName);
//						try {
//							ThingName = URLEncoder.encode(ThingName,"UTF-8");
//						}
//						catch(UnsupportedEncodingException e) {
//							e.printStackTrace();
//							continue;
//						}
//						//System.out.println(ThingName);
//						tmpSplitCol[1] = DateFormat_yyyymmddhh(tmpSplitCol[1]);
//						String RST_Date = tmpSplitCol[1].split(" ")[0]+"T"+tmpSplitCol[1].split(" ")[1];
//						String PS01 = tmpSplitCol[2];
//						String TX01 = tmpSplitCol[3];
//						String RH01 = tmpSplitCol[4];
//						String WD01 = tmpSplitCol[5];
//						String WD02 = tmpSplitCol[6];
//						String SS01 = tmpSplitCol[7];
////						String H_24R = tmpSplitCol[8];
////						String WS15M = tmpSplitCol[9];
////						String WD15M = tmpSplitCol[10];
////						String WS15T = tmpSplitCol[11];
////						String Elev = tmpSplitCol[14];
//						if(!IsThingExist(ThingName)) {  //thing is not exist, create it
//							WHR_json.setPostThingObject_txt(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),RST_Date,PS01,TX01,RH01,WD01,WD02,SS01);
//							Post.doJsonPost(ServerUrlBase+"/Things",WHR_json.getPostThingObject_txt());
//						}
//						else {	//thing is exist, update it
//							// --- get datastream id start ---
//							String Url = ServerUrlBase+"/Things?$filter=name%20eq%20%27"+ThingName+"%27&$expand=Datastreams";
//							GetMethod Get2 = new GetMethod(Url);
//							JSONArray tmpGetJsonArr = Get2.doGetJson().getJSONArray("value");//get all info
//							//System.out.println(tmpGetJsonArr);
//							JSONObject tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(0));//get thing
//							tmpGetJsonArr = tmpJsonObj.getJSONArray("Datastreams");
//							for(int j=0;j<tmpGetJsonArr.size();j++) {//for every datastreams, to get id
//								tmpJsonObj = JSONObject.fromObject(tmpGetJsonArr.get(j));
//								String DataStreamId = tmpJsonObj.getString("@iot.id");
//								String DataStreamName = tmpJsonObj.getString("name");
//								//DataStreamIdMaps.put(DataStreamId, DataStreamName);
//								String PostUrl = ServerUrlBase+"/Datastreams("+DataStreamId+")/Observations";
//								String DataStreamType = DataStreamName.split("-")[2];
//								//System.out.println(PostUrl+", Type: "+DataStreamType);
//								if(DataStreamType.equals("PS01")){
//									WHR_json.setUpdateObject(RST_Date,PS01);
//								}
//								else if(DataStreamType.equals("TX01")) {
//									WHR_json.setUpdateObject(RST_Date,TX01);
//								}
//								else if(DataStreamType.equals("RH01")){
//									WHR_json.setUpdateObject(RST_Date,RH01);
//								}
//								else if(DataStreamType.equals("WD01")){
//									WHR_json.setUpdateObject(RST_Date,WD01);
//								}
//								else if(DataStreamType.equals("WD02")){
//									WHR_json.setUpdateObject(RST_Date,WD02);
//								}
//								else if(DataStreamType.equals("SS01")){
//									WHR_json.setUpdateObject(RST_Date,SS01);
//								}
////								else if(DataStreamType.equals("PRES")){
////									WHR_json.setUpdateObject(RST_Date,PRES);
////								}
////								else if(DataStreamType.equals("HUMD")){
////									WHR_json.setUpdateObject(RST_Date,HUMD);
////								}
////								else if(DataStreamType.equals("TEMP")){
////									WHR_json.setUpdateObject(RST_Date,TEMP);
////								}
////								else if(DataStreamType.equals("WDSD")){
////									WHR_json.setUpdateObject(RST_Date,WDSD);
////								}
////								else if(DataStreamType.equals("WDIR")){
////									WHR_json.setUpdateObject(RST_Date,WDIR);
////								}
//								//System.out.println(RF_json.getUpdateObject());
//								Post.doJsonPost(PostUrl,WHR_json.getUpdateObject());
//							}
//							//System.out.println(DataStreamIdMaps);
//							// --- get datastream id end ---
//						}
//					}else{
//						//System.out.println("there is no sensor");
//					}
//				}
//			}
//		}
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
