package com.mitac.NcdrTransform.Rainfall;

public class RainfallThingJson {
	private String PostThingObject;
	private String UpdateObject;
	public RainfallThingJson() {
		
	}
	public void setUpdateObject(String RST_DATE,String obs) {
		UpdateObject="{\r\n" + 
				"  \"phenomenonTime\": \""+RST_DATE+"\",\r\n" + 
				"  \"resultTime\" : \""+RST_DATE+"\",\r\n" + 
				"  \"result\" : "+obs+"\r\n" + 
				"}";
	}
	public String getUpdateObject() {
		return UpdateObject;
	}
	public void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String Elev) {
		PostThingObject="{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-"+STNM+"\",\r\n" + 
				"\"properties\": {\r\n" + 
				"\"stationID\":\""+STID+"\",\r\n" + 
				"\"stationName\":\""+STNM+"\",\r\n" + 
				"\"city\":\""+CityName+"\",\r\n" + 
				"\"city_SN\":\""+City_SN+"\",\r\n" + 
				"\"township\":\""+TownName+"\",\r\n" + 
				"\"town_SN\":\""+Town_SN+"\",\r\n" + 
				"\"Attribute\":\""+Attribute+"\",\r\n" + 
				"\"AGL\":"+Elev+"\r\n" + 
				"},\r\n" + 
				"\"Locations\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"encodingType\": \"application/vnd.geo+json\",\r\n" + 
				"\"location\": {\r\n" + 
				"\"type\": \"Point\",\r\n" + 
				"\"coordinates\": [\r\n" + 
				""+LON+",\r\n" + 
				""+LAT+"\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"}],\r\n" + 
				"\"Datastreams\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-Hour_1\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-Hour_1\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR DataBase\",\r\n" + 
				"\"description\": \"NCDR DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCDR DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_1\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCDR-1小時雨量資訊\"\r\n" + 
				"}"+ 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-Hour_3\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-Hour_3\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR DataBase\",\r\n" + 
				"\"description\": \"NCDR DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCDR DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_3\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCDR-3小時雨量資訊\"\r\n" + 
				"}"+
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-Hour_24\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-Hour_24\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR DataBase\",\r\n" + 
				"\"description\": \"NCDR DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCDR DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_24\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCDR-24小時雨量資訊\"\r\n" + 
				"}"+ 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
}
