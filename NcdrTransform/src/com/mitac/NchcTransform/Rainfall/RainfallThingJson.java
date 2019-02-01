package com.mitac.NchcTransform.Rainfall;

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
	
	public void setPostThingObject_open(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,
			String OB01,String OB02,String OB03,String OB04,String OB05,String OB06,String OB07,String OB08){
		PostThingObject="{\r\n" + 
				"\"name\": \"雨量站_open-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-"+STNM+"\",\r\n" + 
				"\"properties\": {\r\n" + 
				"\"stationID\":\""+STID+"\",\r\n" + 
				"\"stationName\":\""+STNM+"\",\r\n" + 
				"\"areaDescription\":\""+CityName+TownName+"\",\r\n" + 
				"\"city_SN\":\""+City_SN+"\",\r\n" + 
				"\"town_SN\":\""+Town_SN+"\",\r\n" + 
				"\"Attribute\":\""+Attribute+"\"\r\n" + 
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
				"}\r\n" + 
				"],\r\n" + 
				"\"Datastreams\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-ELEV\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-ELEV\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-ELEV\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-ELEV\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-RAIN\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-RAIN\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-RAIN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-RAIN\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB02+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-MIN_10\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-MIN_10\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-MIN_10\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-MIN_10\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB03+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-HOUR_3\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-HOUR_3\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-HOUR_3\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-HOUR_3\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB04+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-HOUR_6\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-HOUR_6\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-HOUR_6\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-HOUR_6\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB05+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-HOUR_12\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-HOUR_12\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-HOUR_12\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-HOUR_12\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB06+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-HOUR_24\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-HOUR_24\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-HOUR_24\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-HOUR_24\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB07+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"雨量站-"+STID+"-NOW\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-NOW\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC Database\",\r\n" + 
				"\"description\": \"NCHC Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-NOW\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCHC-雨量資訊-NOW\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB08+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public void setPostThingObject_csv(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String Elev) {
		PostThingObject="{\r\n" + 
				"\"name\": \"雨量站_old_2018_NCHC-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"雨量站-"+STID+"-DD_RMN\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-DD_RMN\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC DataBase\",\r\n" + 
				"\"description\": \"NCHC DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCHC DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-DD_RMN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCHC-DD_RMN\"\r\n" + 
				"}"+ 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	
	public void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String Elev) {
		PostThingObject="{\r\n" + 
				"\"name\": \"雨量站_old-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"雨量站-"+STID+"-PP01\",\r\n" + 
				"\"description\": \"雨量站-"+STID+"-PP01\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"NA\",\r\n" + 
				"\"symbol\": \"mm\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCHC DataBase\",\r\n" + 
				"\"description\": \"NCHC DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCHC DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-PP01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCHC-降水量\"\r\n" + 
				"}"+ 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	
	public void setPostThingObject_old(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String Elev) {
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
				"\"name\": \"NCHC DataBase\",\r\n" + 
				"\"description\": \"NCHC DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCHC DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_1\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCHC-1小時雨量資訊\"\r\n" + 
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
				"\"name\": \"NCHC DataBase\",\r\n" + 
				"\"description\": \"NCHC DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCHC DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_3\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCHC-3小時雨量資訊\"\r\n" + 
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
				"\"name\": \"NCHC DataBase\",\r\n" + 
				"\"description\": \"NCHC DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NCHC DataBase\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"雨量站-Hour_24\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"NCHC-24小時雨量資訊\"\r\n" + 
				"}"+ 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
}
