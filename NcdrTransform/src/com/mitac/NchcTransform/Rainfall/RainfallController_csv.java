package com.mitac.NchcTransform.Rainfall;

import java.io.FileWriter;
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
import com.mitac.NchcTransform.Weather.WeatherThingJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RainfallController_csv {
	private String ServerUrlBase;
	Date date = new Date();
	
	SimpleDateFormat SDF = new SimpleDateFormat ("yyyyMMddHH00");
	
	public RainfallController_csv(String ServerUrlBase) {
		this.ServerUrlBase = ServerUrlBase;
	}
	public RainfallController_csv() {
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
	
	public String DateFormat_yyyymmddhhmm (String date){
		SimpleDateFormat SDF = new SimpleDateFormat ("yyyy/MM/dd HH:mm");
		SDF.setLenient(false);
		Date newDate = null;
		try {
			newDate = SDF.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return SDF.format(newDate).toString();
	}
	
	//歷史資料2017以前
	public void UpdateThing(String path) {
		//get weather update stid array
		GetMethod Get = new GetMethod();
		List<String> TmpList = Get.doGetStrList_rainfall_2018(path);
		
		RainfallThingJson RF_json = new RainfallThingJson();
		PostMethod Post = new PostMethod();
		
//		System.out.println("Weather Update size: "+(TmpList.size()-1));
		// --- add start ---------
		JSONArray tmpArr_StidList = new GetStidJsonArray().getJsonArr();
		JSONObject tmp = new JSONObject();
		// --- add stop ---------
		
		int ColNum=0;
		int countSTID=0;
		for(int i=0;i<TmpList.size();i++) {//TmpList.size()
			String[] tmpSplitCol = TmpList.get(i).split(",");
			for(int i1=0; i1<tmpSplitCol.length; i1++){
				tmpSplitCol[i1] = tmpSplitCol[i1].replace("\"", "");
				if(tmpSplitCol[i1].trim().isEmpty()){
					//System.out.println("空的");
					tmpSplitCol[i1] = "0";
				}
			}
			if(i==0) {
				ColNum = tmpSplitCol.length;
			}
			else {
				if(tmpSplitCol.length==ColNum) {
					for(int o=0;o<tmpArr_StidList.size();o++) {
						tmp = tmpArr_StidList.getJSONObject(o);
						if(tmpSplitCol[1].equals(tmp.getString("STID").substring(0, 5))) { //find it, break
							countSTID++;
							//break;
						}
					}
					for(int o=0;o<tmpArr_StidList.size();o++) {
						tmp = tmpArr_StidList.getJSONObject(o);
						if(tmpSplitCol[1].equals(tmp.getString("STID").substring(0, 5))) { //find it, break
							//countSTID++;
							break;
						}
					}
					//System.out.println("why========="+tmpSplitCol[1]);
					if(countSTID==1) { //check again, avoid STID not found
						String Stid = tmp.getString("STID");
						String Stnm = tmp.getString("STNM");
						String ThingName = "雨量站_old_2018-"+Stid+"-"+Stnm;
						//System.out.println(ThingName);
						try {
							ThingName = URLEncoder.encode(ThingName,"UTF-8");
						}
						catch(UnsupportedEncodingException e) {
							e.printStackTrace();
							continue;
						}
						//System.out.println(ThingName);
						//tmpSplitCol[0] = DateFormat_yyyymmddhhmm(tmpSplitCol[0]);
						String RST_Date = tmpSplitCol[0].split(" ")[0]+"T"+tmpSplitCol[0].split(" ")[1];
						String DD_RMN = tmpSplitCol[3];
						
						if(!IsThingExist(ThingName)) {  //thing is not exist, create it
							RF_json.setPostThingObject_csv(tmp.getString("STID"),tmp.getString("STNM"),tmp.getString("LAT"),tmp.getString("LON"),tmp.getString("CityName"),tmp.getString("City_SN"),tmp.getString("TownName"),tmp.getString("Town_SN"),tmp.getString("Attribute"),"0");
							//System.out.println("thing=========="+RF_json.getPostThingObject());
							Post.doJsonPost(ServerUrlBase+"/Things",RF_json.getPostThingObject());
						}
						
						//System.out.println(ThingName);
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
//								System.out.println(PostUrl+", Type: "+DataStreamType);
								if(DataStreamType.equals("DD_RMN")){
									RF_json.setUpdateObject(RST_Date,DD_RMN);
								}
								//System.out.println("update=========="+RF_json.getUpdateObject());
								Post.doJsonPost(PostUrl,RF_json.getUpdateObject());
							}
							//System.out.println(DataStreamIdMaps);
							// --- get datastream id end ---
							countSTID = 0;
					}else{
						//System.out.println("there is no sensor");
						String newPath = path.replace(".csv", "_log.txt");
						FileWriter fw;
						try {
							fw = new FileWriter(newPath, true);
							fw.write("Warning countSTID=" + countSTID + " STNM=" + tmp.getString("STNM") + " STID=" + tmp.getString("STID") + " CSVid=" + tmpSplitCol[1] + "\r\n");
							fw.flush();
							fw.close();
							
							countSTID = 0;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
		}
//		System.out.println("File: "+path);
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
