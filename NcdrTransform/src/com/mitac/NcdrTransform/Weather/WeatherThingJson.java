package com.mitac.NcdrTransform.Weather;

public class WeatherThingJson {
	private String PostThingObject;
	private String PostThingObject_old;
	private String PostThingObject_txt;
	private String UpdateObject;
	public WeatherThingJson() {
		
	}
	public void setUpdateObject(String RST_DATE,String obs) {
		UpdateObject="{\r\n" + 
				"  \"phenomenonTime\": \""+RST_DATE+"\",\r\n" +
				"  \"result\" : "+obs+"\r\n" + 
				"}";
	}
	public String getUpdateObject() {
		return UpdateObject;
	}
	
	public void setPostThingObject_open(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,
			String OB01,String OB02,String OB03,String OB04,String OB05,String OB06,String OB07,String OB08,String OB09,String OB10,
			String OB11,String OB12,String OB13,String OB14,String OB15){
		PostThingObject="{\r\n" + 
				"\"name\": \"氣象站_open-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-ELEV\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-ELEV\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-ELEV\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-ELEV\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WDIR\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WDIR\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WDIR\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-WDIR\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB02+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WDSD\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WDSD\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WDSD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-WDSD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB03+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-TEMP\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-TEMP\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-TEMP\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-TEMP\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB04+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-HUMD\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-HUMD\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-HUMD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-HUMD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB05+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-PRES\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-PRES\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-PRES\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-PRES\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB06+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-SUN\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-SUN\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-SUN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-SUN\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB07+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-H_24RNA\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-H_24RNA\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-H_24RNA\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-H_24RNA\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB08+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-H_FX\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-H_FX\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-H_FX\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-H_FX\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB09+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-H_XD\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-H_XD\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-H_XD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-H_XD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB10+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-H_FXT\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-H_FXT\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-H_FXT\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-H_FXT\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB11+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-D_TX\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-D_TX\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-D_TX\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-D_TX\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB12+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-D_TXT\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-D_TXT\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-D_TXT\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-D_TXT\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB13+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-D_TN\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-D_TN\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-D_TN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-D_TN\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB14+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-D_TNT\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-D_TNT\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-D_TNT\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-D_TNT\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB15+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,
			String OB01,String OB02,String OB03,String OB04,String OB05,String OB06,String OB07,String OB08,String OB09,String OB10,
			String OB11,String OB12,String OB13,String OB14,String OB15,String OB16,String OB17,String OB18,String OB19,String OB20){
		PostThingObject="{\r\n" + 
				"\"name\": \"氣象站_old_2018-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-風速\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-風速\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \"m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-風速\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-風速\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-風向\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-風向\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-風向\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-風向\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB02+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-濕度\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-濕度\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"百分比率0-1\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-濕度\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-濕度\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB03+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-氣壓\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-氣壓\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"hPa\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-氣壓\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-氣壓\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB04+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-氣溫\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-氣溫\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-氣溫\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-氣溫\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB05+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-紫外線指數\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-紫外線指數\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-紫外線指數\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-紫外線指數\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB06+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日累積雨量\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日累積雨量\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日累積雨量\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日累積雨量\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB07+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日最高溫度\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日最高溫度\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日最高溫度\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日最高溫度\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB08+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日最高溫度發生時間\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日最高溫度發生時間\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"hhmm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日最高溫度發生時間\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日最高溫度發生時間\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB09+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日最低溫度\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日最低溫度\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日最低溫度\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日最低溫度\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB10+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日最低溫度發生時間\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日最低溫度發生時間\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"hhmm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日最低溫度發生時間\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日最低溫度發生時間\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB11+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日照時數\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日照時數\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日照時數\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日照時數\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB12+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時極大風速\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時極大風速\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \"m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-小時極大風速\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-小時極大風速\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB13+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時極大風向\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時極大風向\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-小時極大風向\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-小時極大風向\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB14+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時極大風速發生時間\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時極大風速發生時間\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"hhmm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-小時極大風速發生時間\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-小時極大風速發生時間\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB15+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時最大10分鐘平均風速\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時最大10分鐘平均風速\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \"m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-小時最大10分鐘平均風速\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-小時最大10分鐘平均風速\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB16+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時最大10分鐘平均風向\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時最大10分鐘平均風向\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-小時最大10分鐘平均風向\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-小時最大10分鐘平均風向\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB17+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-小時最大10分鐘平均風速發生時間\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-小時最大10分鐘平均風速發生時間\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"hhmm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"小時最大10分鐘平均風速發生時間\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-小時最大10分鐘平均風速發生時間\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB18+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-能見度\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-能見度\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"kilometer\",\r\n" + 
				"\"symbol\": \"km\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-能見度\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-能見度\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB19+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-日累積全天空日輻射\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日累積全天空日輻射\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"MJ/m2\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-日累積全天空日輻射\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊-日累積全天空日輻射\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+OB20+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public void setPostThingObject_txt(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,String PS01,String TX01,String RH01,String WD01,String WD02,String SS01){
		PostThingObject_txt="{\r\n" + 
				"\"name\": \"氣象站_old-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-PS01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-測站氣壓\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"hundredPascal\",\r\n" + 
				"\"symbol\": \"hPa\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-PS01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊PS01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+PS01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-TX01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-氣溫\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \" ℃\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-TX01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊TX01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+TX01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-RH01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-RH01(相對濕度)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"percentage\",\r\n" + 
				"\"symbol\": \"%\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-RH01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊RH01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+RH01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WD01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-平均風風速\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \"m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WD01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊WD01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WD02\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WD02(平均風風向)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WD02\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊WD02\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD02+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-SS01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-日照時數\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"hour\",\r\n" + 
				"\"symbol\": \"hr\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-SS01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊SS01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+SS01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public void setPostThingObject_old(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,String WDIR,String WDSD,String TEMP,String HUMD,String PRES,String SUN,String H_24R,String Elev,String WS15M,String WD15M,String WS15T) {
		PostThingObject_old="{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-WDIR\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WDIR(風向)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degrees\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WDIR\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 WDIR\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WDIR+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WDSD\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WDSD(風速)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \" m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WDSD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 WDSD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WDSD+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-TEMP\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-TEMP(溫度)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"Celsius\",\r\n" + 
				"\"symbol\": \"°C\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-TEMP\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 TEMP\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+TEMP+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-HUMD\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-HUMD(相對溼度)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"percentage\",\r\n" + 
				"\"symbol\": \"%\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-HUMD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 HUMD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+HUMD+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-PRES\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-PRES(氣壓)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"hectopascal\",\r\n" + 
				"\"symbol\": \"hPa\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-PRES\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 PRES\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+PRES+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-SUN\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-SUN(日照時數)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"hour\",\r\n" + 
				"\"symbol\": \"h\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-SUN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 SUN\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+SUN+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-H_24R\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-H_24R(日累積雨量)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"millimeter\",\r\n" + 
				"\"symbol\": \"mm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-H_24R\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 H_24R\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+H_24R+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-Elev\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-Elev(地表起算高程)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \"NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-Elev\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 Elev\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+Elev+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WS15M\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WS15M(觀測時間前推十五分鐘內發生最大風的風速)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"meter per second\",\r\n" + 
				"\"symbol\": \"m/s\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WS15M\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 WS15M\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WS15M+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WD15M\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WD15M(觀測時間前推十五分鐘內發生最大風的風向)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degrees\",\r\n" + 
				"\"symbol\": \"°\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WD15M\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 WD15M\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD15M+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"氣象站-"+STID+"-WS15T\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-WS15T(觀測時間前推十五分鐘內發生最大風的發生時間)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"time\",\r\n" + 
				"\"symbol\": \"hh:mm\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"氣象站-WS15T\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-氣象資訊 WS15T\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WS15T+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	public String getPostThingObject() {
		return this.PostThingObject;
	}
	public String getPostThingObject_txt() {
		return this.PostThingObject_txt;
	}
}
