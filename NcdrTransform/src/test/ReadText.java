package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadText {
	
	public static String PostThingObject;
	
	public static void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,String PS01,String TX01,String RH01,String WD01,String WD02,String SS01){
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
				"\"name\": \"��H��-"+STID+"-PS01\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-PS01\",\r\n" + 
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
				"\"name\": \"��H��-PS01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TPS01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+PS01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-TX01\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-TX01\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"NA\",\r\n" + 
				"\"symbol\": \" NA\",\r\n" + 
				"\"definition\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"Sensor\": {\r\n" + 
				"\"name\": \"NCDR Database\",\r\n" + 
				"\"description\": \"NCDR Database\",\r\n" + 
				"\"encodingType\": \"application/pdf\",\r\n" + 
				"\"metadata\": \"NA\"\r\n" + 
				"},\r\n" + 
				"\"ObservedProperty\": {\r\n" + 
				"\"name\": \"��H��-TX01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TTX01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+TX01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-RH01\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-RH01(�۹����)\",\r\n" + 
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
				"\"name\": \"��H��-RH01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TRH01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+RH01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WD01\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WD01\",\r\n" + 
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
				"\"name\": \"��H��-WD01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TWD01\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD01+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-WD02\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-WD02(���������V)\",\r\n" + 
				"\"observationType\": \"http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement\",\r\n" + 
				"\"unitOfMeasurement\": {\r\n" + 
				"\"name\": \"degree\",\r\n" + 
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
				"\"name\": \"��H��-WD02\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TWD02\"\r\n" + 
				"},\r\n" + 
				"\"Observations\": [\r\n" + 
				"{\r\n" + 
				"\"phenomenonTime\": \""+RST_Date+"\",\r\n" + 
				"\"result\":"+WD02+"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"name\": \"��H��-"+STID+"-SS01\",\r\n" + 
				"\"description\": \"��H��-"+STID+"-SS01\",\r\n" + 
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
				"\"name\": \"��H��-SS01\",\r\n" + 
				"\"definition\": \"NA\",\r\n" + 
				"\"description\": \"NCDR-��H��TSS01\"\r\n" + 
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		int i = 0;
//		FileReader fr = new FileReader("C:\\NCDR_history\\weather\\Metro_1998-2017.txt");
//		BufferedReader br = new BufferedReader(fr);
//		FileWriter fw = new FileWriter("C:\\NCDR_history\\weather\\Metro_1998-2017_10.txt");
//		while (br.ready()) {
//			System.out.println(br.readLine());
//			fw.write(br.readLine()+"\n");
//			i++;
//			if(i>100){
//				break;
//			}
//		}
//		fw.flush();
//		fw.close();
//		fr.close();
		setPostThingObject("321","321","123213","321","321","321","321","321","321","321","123","123","321","321","321","321");
		System.out.println(PostThingObject);
		
		
	}
}
