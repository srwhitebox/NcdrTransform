package com.mitac.NcdrTransform.CCTV;

public class CctvThingJson {
	private String PostThingObject;
	//private String UpdateObject;
	public CctvThingJson() {
		
	}
//	public void setUpdateObject(String RST_DATE,String Stage) {
//		UpdateObject="{\r\n" + 
//				"  \"phenomenonTime\": \""+RST_DATE+"\",\r\n" + 
//				"  \"resultTime\" : \""+RST_DATE+"\",\r\n" + 
//				"  \"result\" : "+Stage+"\r\n" + 
//				"}";
//	}
//	public String getUpdateObject() {
//		return UpdateObject;
//	}
	public void setPostThingObject(String STID,String Location,String URL,String WGS84_Lon,String WGS84_Lat,String Update_date) {
		PostThingObject="{\r\n" + 
				"\"name\": \"CCTV-"+STID+"-"+Location+"\",\r\n" + 
				"\"description\": \"CCTV-"+STID+"-"+Location+"\",\r\n" + 
				"\"properties\": {\r\n" + 
				"\"stationID\":\""+STID+"\",\r\n" + 
				"\"Location\":\""+Location+"\"\r\n" + 
				"},\r\n" + 
				"\"Locations\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"CCTV-"+STID+"-"+Location+"\",\r\n" + 
				"\"description\": \"CCTV-"+STID+"-"+Location+"\",\r\n" + 
				"\"encodingType\": \"application/vnd.geo+json\",\r\n" + 
				"\"location\": {\r\n" + 
				"\"type\": \"Point\",\r\n" + 
				"\"coordinates\": [\r\n" + 
				""+WGS84_Lon+",\r\n" + 
				""+WGS84_Lat+"\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"}],\r\n" + 
				"\"Datastreams\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"CCTV-"+STID+"-URL\",\r\n" + 
				"\"description\": \"CCTV-"+STID+"-URL\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Observation\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\":\"videostream\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\":\"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR DataBase\",\r\n" + 
				"\"description\": \"NCDR DataBase\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"https://www.ncdr.nat.gov.tw/\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"CCTV-URL\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\":\"CCTV-即時資訊\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+Update_date+"\",\r\n" + 
				" 	\"resultTime\" : \""+Update_date+"\",\r\n" + 
				" 	\"result\" : \""+URL+"\"" + 
				"}]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
}
