package com.mitac.NcdrTransform.Weather;

public class WeatherThingJson {
	private String PostThingObject;
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
	public void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,String WDIR,String WDSD,String TEMP,String HUMD,String PRES,String SUN,String H_24R,String Elev,String WS15M,String WD15M,String WS15T) {
		PostThingObject="{\r\n" + 
				"\"name\": \"��H��-"+STID+"-"+STNM+"\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-"+STNM+"\",\r\n" + 
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
				"\"name\": \"��H��-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-"+CityName+TownName+STNM+"\",\r\n" + 
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
				"\"name\": \"��H��-"+STID+"-WDIR\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WDIR(���V)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degrees\",\r\n" + 
				"\"symbol\": \"�X\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"��H��-WDIR\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T WDIR\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WDIR+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WDSD\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WDSD(���t)\",\r\n" + 
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
				"\"name\": \"��H��-WDSD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T WDSD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WDSD+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-TEMP\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-TEMP(�ū�)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"Celsius\",\r\n" + 
				"\"symbol\": \"�XC\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"��H��-TEMP\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T TEMP\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+TEMP+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-HUMD\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-HUMD(�۹�ë�)\",\r\n" + 
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
				"\"name\": \"��H��-HUMD\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T HUMD\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+HUMD+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-PRES\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-PRES(����)\",\r\n" + 
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
				"\"name\": \"��H��-PRES\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T PRES\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+PRES+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-SUN\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-SUN(��Ӯɼ�)\",\r\n" + 
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
				"\"name\": \"��H��-SUN\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T SUN\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+SUN+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-H_24R\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-H_24R(��ֿn�B�q)\",\r\n" + 
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
				"\"name\": \"��H��-H_24R\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T H_24R\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+H_24R+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-Elev\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-Elev(�a��_�Ⱚ�{)\",\r\n" + 
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
				"\"name\": \"��H��-Elev\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T Elev\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+Elev+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WS15M\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WS15M(�[���ɶ��e���Q���������o�ͳ̤j�������t)\",\r\n" + 
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
				"\"name\": \"��H��-WS15M\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T WS15M\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WS15M+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WD15M\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WD15M(�[���ɶ��e���Q���������o�ͳ̤j�������V)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degrees\",\r\n" + 
				"\"symbol\": \"�X\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"��H��-WD15M\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T WD15M\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD15M+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WS15T\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WS15T(�[���ɶ��e���Q���������o�ͳ̤j�����o�ͮɶ�)\",\r\n" + 
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
				"\"name\": \"��H��-WS15T\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��T WS15T\"\r\n" + 
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
}
