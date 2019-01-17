package com.mitac.NcdrTransform.ReservoirWaterLevel;

public class ReservoirWaterLevelThingJson {
	private String PostThingObject;
	private String UpdateObject;
	public ReservoirWaterLevelThingJson() {
		
	}
	public void setUpdateObject(String RST_DATE,String WaterLine) {
		UpdateObject="{\r\n" + 
				"  \"phenomenonTime\": \""+RST_DATE+"\",\r\n" + 
				"  \"resultTime\" : \""+RST_DATE+"\",\r\n" + 
				"  \"result\" : "+WaterLine+"\r\n" + 
				"}";
	}
	public String getUpdateObject() {
		return UpdateObject;
	}
	public void setPostThingObject(String ST_NO,String RES_NAME,String BASIN_NO,String RV_NAME,String CAPACITY_E,String NWL_MX,String DWL,String Enabled,String Capacity_T,String HydraulicStructure,String FloodPrevention,String Importance,String Upload,String KeyInIrrigate,String KeyInPublic,String KeyInIndustial,String KeyInElectric,String KeyInFlood,String Note,String WriteDateTime,String WGS84_Lon,String WGS84_Lat) {
		PostThingObject="{\r\n" + 
				"\"name\":\"水位站-"+ST_NO+"-"+RES_NAME+"\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-"+RES_NAME+"\",\r\n" + 
				"\"properties\": {\r\n" + 
				"\"stationID\": "+ST_NO+",\r\n" + 
				"\"stationName\": \""+RES_NAME+"\",\r\n" + 
				"\"affiliatedBasin\": "+BASIN_NO+",\r\n" + 
				"\"riverName \": \""+RV_NAME+"\",\r\n" + 
				"\"CAPACITY_E\": "+CAPACITY_E+",\r\n" + 
				"\"NWL_MX\": "+NWL_MX+",\r\n" + 
				"\"DWL\": "+DWL+",\r\n" + 
				"\"Enabled\": \""+Enabled+"\",\r\n" + 
				"\"CAPACITY_T\": "+Capacity_T+",\r\n" + 
				"\"HydraulicStructure\": "+HydraulicStructure+",\r\n" + 
				"\"FloodPrevention\":"+FloodPrevention+",\r\n" + 
				"\"Importance\": "+Importance+",\r\n" + 
				"\"Upload\": "+Upload+",\r\n" + 
				"\"KeyInIrrigate\": \""+KeyInIrrigate+"\",\r\n" + 
				"\"KeyInPublic\": \""+KeyInPublic+"\",\r\n" + 
				"\"KeyInIndustial\":\""+KeyInIndustial+"\",\r\n" + 
				"\"KeyInElectric\": \""+KeyInElectric+"\",\r\n" + 
				"\"KeyInFlood\": \""+KeyInFlood+"\",\r\n" + 
				"\"remark\": \""+Note+"\"\r\n" + 
				"},\r\n" + 
				"\"Locations\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"水位站-"+ST_NO+"-"+RES_NAME+"\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-"+RES_NAME+"\",\r\n" + 
				"\"encodingType\": \"application/vnd.geo+json\",\r\n" + 
				"\"location\": {\r\n" + 
				"\"type\": \"Point\",\r\n" + 
				"\"coordinates\": [\r\n" + 
				""+WGS84_Lon+",\r\n" + 
				""+WGS84_Lat+"\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"}\r\n" + 
				"],\r\n" + 
				"\"Datastreams\": [\r\n" + 
				"{\r\n" + 
				"\"name\": \"水位站-"+ST_NO+"-WaterLine\",\r\n" + 
				"\"description\": \"水位站-"+ST_NO+"-WaterLine\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter\",\r\n" + 
				"\"symbol\": \"m\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"  \"name\": \"NCDR Database\",\r\n" + 
				"  \"description\": \"NCDR Database\",\r\n" + 
				"  \"encodingType\": \"application/pdf\",\r\n" + 
				"  \"metadata\": \"https://www.ncdr.nat.gov.tw/\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"水位站-WaterLine\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"水位站-目前水位標高\"\r\n" + 
				"}\r\n" +
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
}
