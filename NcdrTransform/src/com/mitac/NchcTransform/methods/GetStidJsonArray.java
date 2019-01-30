package com.mitac.NchcTransform.methods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStidJsonArray {
	
	public JSONArray getJsonArr() {
		GetMethod GetRain = new GetMethod("https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0002-001?Authorization=rdec-key-123-45678-011121314");
		JSONObject GetJson = GetRain.doGetJson_https();//Get Json from UpdateNcdrUrl
		JSONObject JSONObjectRecords = GetJson.getJSONObject("records");
		JSONArray GetJsonArr = JSONObjectRecords.getJSONArray("location");
		JSONObject tmp = new JSONObject();
		JSONArray tmpArr_tmpList = new JSONArray();
		String STID = "";
		String STNM = "";
		String LAT = "";
		String LON = "";
		String CityName = "";
		String City_SN = "";
		String TownName = "";
		String Town_SN = "";
		String Attribute = "";
		for(int j=0;j<GetJsonArr.size();j++) {
			tmp = JSONObject.fromObject(GetJsonArr.get(j));
			JSONArray tmpArr = tmp.getJSONArray("parameter");
			STID = tmp.getString("stationId");
			STNM = tmp.getString("locationName");
			LAT = tmp.getString("lat");
			LON = tmp.getString("lon");
			for(int k=0;k<tmpArr.size();k++) {
				JSONObject Obj_parameter = tmpArr.getJSONObject(k);
				if(Obj_parameter.getString("parameterName").equals("CITY")) CityName=Obj_parameter.getString("parameterValue");
				if(Obj_parameter.getString("parameterName").equals("CITY_SN")) City_SN=Obj_parameter.getString("parameterValue");
				if(Obj_parameter.getString("parameterName").equals("TOWN")) TownName=Obj_parameter.getString("parameterValue");
				if(Obj_parameter.getString("parameterName").equals("TOWN_SN")) Town_SN=Obj_parameter.getString("parameterValue");
				if(Obj_parameter.getString("parameterName").equals("ATTRIBUTE")) Attribute=Obj_parameter.getString("parameterValue");
			}
//			System.out.println(STID+","+STNM+","+LAT+","+LON+","+CityName+","+City_SN+","+TownName+","+Town_SN+","+Attribute);
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
			tmpArr_tmpList.add(tmp);
		}
		return tmpArr_tmpList;
	}
}
