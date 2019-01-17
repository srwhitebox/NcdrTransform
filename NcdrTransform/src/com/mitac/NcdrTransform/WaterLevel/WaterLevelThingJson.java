package com.mitac.NcdrTransform.WaterLevel;

public class WaterLevelThingJson {
	private String PostThingObject;
	private String UpdateObject;
	public WaterLevelThingJson() {
		
	}
	public void setUpdateObject(String RST_DATE,String Stage) {
		UpdateObject="{\r\n" + 
				"  \"phenomenonTime\": \""+RST_DATE+"\",\r\n" + 
				"  \"resultTime\" : \""+RST_DATE+"\",\r\n" + 
				"  \"result\" : "+Stage+"\r\n" + 
				"}";
	}
	public String getUpdateObject() {
		return UpdateObject;
	}
	public void setPostThingObject(String ST_NO,String NAME_C,String BASIN_NO,String ADDR_C,String WarningLine1,String WarningLine2,String WarningLine3,String PlanFloodLine,String TopLine,String BottomLine,String nWGS84_Lon,String nWGS84_Lat,String Attribute) {
		PostThingObject="{\r\n" + 
				"\"name\":\"水位站-"+ST_NO+"-"+NAME_C+"\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-"+NAME_C+"\",\r\n" + 
				"\"properties\": {\r\n" + 
				"\"stationID\": \""+ST_NO+"\",\r\n" + 
				"\"stationName\": \""+NAME_C+"\",\r\n" + 
				"\"areaDescription\": \""+ADDR_C+"\",\r\n" + 
				"\"alertLevel1 \": "+WarningLine1+",\r\n" + 
				"\"alertLevel2\": "+WarningLine2+",\r\n" + 
				"\"alertLevel3\": "+WarningLine3+",\r\n" + 
				"\"planFloodLine\": "+PlanFloodLine+",\r\n" + 
				"\"topLine\": "+TopLine+",\r\n" + 
				"\"bottomLine\": "+BottomLine+",\r\n" + 
				"\"affiliatedBasin\": "+BASIN_NO+",\r\n" + 
				"\"Attribute\":\""+Attribute+"\"\r\n" + 
				"},\r\n" + 
				"\"Locations\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"水位站-"+ST_NO+"-"+NAME_C+"\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-"+ADDR_C+"-"+NAME_C+"\",\r\n" + 
				"\"encodingType\": \"application/vnd.geo+json\",\r\n" + 
				"\"location\": {\r\n" + 
				"\"type\": \"Point\",\r\n" + 
				"\"coordinates\": [\r\n" + 
				""+nWGS84_Lon+",\r\n" + 
				""+nWGS84_Lat+"\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"}\r\n" + 
				"],\r\n" + 
				"\"Datastreams\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"水位站-"+ST_NO+"-Stage\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-Stage\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"  \"name\": \"NCDR Database\",\r\n" + 
				"  \"description\": \"NCDR Database\",\r\n" + 
				"  \"encodingType\": \"application/pdf\",\r\n" + 
				"  \"metadata\": \"https://www.ncdr.nat.gov.tw/\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"水位站-Stage\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"水位站-水位資訊\"\r\n" + 
				"}\r\n"+ 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
}
