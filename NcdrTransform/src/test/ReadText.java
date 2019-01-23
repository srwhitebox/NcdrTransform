package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import com.mitac.NchcTransform.methods.GetMethod;
import com.mitac.NchcTransform.Weather.WeatherController;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;



public class ReadText {

	public static String PostThingObject;

	public static void setPostThingObject(String STID,String STNM,String LAT,String LON,String CityName,String City_SN,String TownName,String Town_SN,String Attribute,String RST_Date,String PS01,String TX01,String RH01,String WD01,String WD02,String SS01){
		PostThingObject="{\r\n" + 
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
				"\"name\": \"氣象站-"+STID+"-PS01\",\r\n" + 
				"\"description\": \"氣象站-"+STID+"-PS01\",\r\n" + 
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
				"\"description\": \"氣象站-"+STID+"-TX01\",\r\n" + 
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
				"\"description\": \"氣象站-"+STID+"-WD01\",\r\n" + 
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
				"\"description\": \"氣象站-"+STID+"-SS01\",\r\n" + 
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

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
//		List<String> ResList = new ArrayList<>();
//		String CurrentLine;
//		int i = 0;
//		BufferedReader br = 
//		        new BufferedReader(new InputStreamReader(
//		            new FileInputStream("C:\\NCDR_history\\rainfall\\Rain_1998-2017_10.txt"),"utf-8"));
//		//FileWriter fw = new FileWriter("C:\\NCDR_history\\rainfall\\Rain_1998-2017_10.txt");
//		while ((CurrentLine = br.readLine()) != null) {
//			//if(i>102){
//			//	break;
//			//}
//			//fw.write(CurrentLine + "\r\n");
//			System.out.println(CurrentLine);
//			//i++;
//		}
//		//fw.flush();
//		//fw.close();
//		br.close();
		
//		WeatherController wc = new WeatherController();
//		GetMethod Get = new GetMethod();
//		List<String> TmpList = Get.doGetStrList_rainfall_2018();
//		String[] tmpSplitCol = TmpList.get(2).split(",");
//		for(String data :tmpSplitCol){
//			System.out.println(data);
//		}
//		
//		
//		String RST_Date = tmpSplitCol[0].split(" ")[0]+"T"+tmpSplitCol[0].split(" ")[1];
//		System.out.println(RST_Date);
		
		//連線開放資料取得JSON
//		final String CreateNcdrUrl = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0001-001?Authorization=rdec-key-123-45678-011121314";
//		GetMethod GetRain = new GetMethod(CreateNcdrUrl);
//		net.sf.json.JSONObject GetJson = GetRain.doGetJson_https().getJSONObject("records");
//		JSONArray GetJsonArr = GetJson.getJSONArray("location");
//		Object jsonOb = GetJsonArr.get(0);
		
		String CreateAndUpdateUrl = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0001-001?Authorization=rdec-key-123-45678-011121314";
		//String testJson = "{\"lat\":\"24.778333\",\"lon\":\"121.494583\",\"locationName\":\"福山\",\"stationId\":\"C0A560\",\"time\":{\"obsTime\":\"2019-01-22 16:00:00\"},\"weatherElement\":[{\"elementName\":\"ELEV\",\"elementValue\":\"405.0\"},{\"elementName\":\"WDIR\",\"elementValue\":\"291\"},{\"elementName\":\"WDSD\",\"elementValue\":\"0.6\"},{\"elementName\":\"TEMP\",\"elementValue\":\"10.0\"},{\"elementName\":\"HUMD\",\"elementValue\":\"0.88\"},{\"elementName\":\"PRES\",\"elementValue\":\"972.1\"},{\"elementName\":\"SUN\",\"elementValue\":\"-99\"},{\"elementName\":\"H_24R\",\"elementValue\":\"0.0\"},{\"elementName\":\"H_FX\",\"elementValue\":\"-99\"},{\"elementName\":\"H_XD\",\"elementValue\":\"-99\"},{\"elementName\":\"H_FXT\",\"elementValue\":\"-99\"},{\"elementName\":\"D_TX\",\"elementValue\":\"12.40\"},{\"elementName\":\"D_TXT\",\"elementValue\":\"null\"},{\"elementName\":\"D_TN\",\"elementValue\":\"9.80\"},{\"elementName\":\"D_TNT\",\"elementValue\":\"null\"}],\"parameter\":[{\"parameterName\":\"CITY\",\"parameterValue\":\"新北市\"},{\"parameterName\":\"CITY_SN\",\"parameterValue\":\"06\"},{\"parameterName\":\"TOWN\",\"parameterValue\":\"烏來區\"},{\"parameterName\":\"TOWN_SN\",\"parameterValue\":\"061\"}]}";
		GetMethod Get = new GetMethod(CreateAndUpdateUrl);
		JSONObject OpenDataList = Get.doGetJson_https().getJSONObject("records");
		JSONArray GetJsonArr_Open = OpenDataList.getJSONArray("location");
		for(int i=0;i<3;i++){
			JSONObject OpenJson = (JSONObject) GetJsonArr_Open.get(i);
			
			JSONObject OpenJson_Time = (JSONObject) OpenJson.get("time");
			String RST_Date = OpenJson_Time.get("obsTime").toString().split(" ")[0]+"T"+OpenJson_Time.get("obsTime").toString().split(" ")[1];
			JSONArray obOpen = OpenJson.getJSONArray("weatherElement");
			
			String ELEV = null;
			String WDIR = null;
			String WDSD = null;
			String TEMP = null;
			String HUMD = null;
			String PRES = null;
			String SUN = null;
			String H_24RNA = null;
			String H_FX = null;
			String H_XD = null;
			String H_FXT = null;
			String D_TX = null;
			String D_TXT = null;
			String D_TN = null;
			String D_TNT = null;
			
			for(int k=0; k<obOpen.size(); k++){
				JSONObject weatherElement = (JSONObject) obOpen.get(k);
				String obData = weatherElement.getString("elementName");
				switch (obData){
				case "ELEV":
					ELEV = weatherElement.getString("elementValue");
		            break;
				case "WDIR":
					WDIR = weatherElement.getString("elementValue");
		            break;
				case "WDSD":
					WDSD = weatherElement.getString("elementValue");
		            break;
				case "TEMP":
					TEMP = weatherElement.getString("elementValue");
		            break;
				case "HUMD":
					HUMD = weatherElement.getString("elementValue");
		            break;
				case "PRES":
					PRES = weatherElement.getString("elementValue");
		            break;
				case "SUN":
					SUN = weatherElement.getString("elementValue");
		            break;
				case "H_24RNA":
					H_24RNA = weatherElement.getString("elementValue");
		            break;
				case "H_FX":
					H_FX = weatherElement.getString("elementValue");
		            break;
				case "H_XD":
					H_XD = weatherElement.getString("elementValue");
		            break;
				case "H_FXT":
					H_FXT = weatherElement.getString("elementValue");
		            break;
				case "D_TX":
					D_TX = weatherElement.getString("elementValue");
		            break;
				case "D_TXT":
					D_TXT = weatherElement.getString("elementValue");
		            break;
				case "D_TN":
					D_TN = weatherElement.getString("elementValue");
		            break;
				case "D_TNT":
					D_TNT = weatherElement.getString("elementValue");
		            break;
		            }
			}
			
			
			System.out.println(OpenJson.get("stationId").toString());
			
		}
		
		
		//JSONObject tmp = null;
		
		//JSONObject j = new JSONObject(testJson);
		//JSONObject j_2 = (JSONObject) j.get("time");
		//org.json.JSONArray GetJsonArr_1 = j.getJSONArray("weatherElement");
		//JSONObject obOpen = (JSONObject) (GetJsonArr_1.get(0));

		
		//System.out.println(j.get("stationId").toString());
		//System.out.println(j_2.get("obsTime").toString());
		//System.out.println(j_3.getString("elementName"));
		//String level = j_3.getString("elementName");
		
		
		//讀寫檔案(auto.txt)
//		 List<String> ResList = new ArrayList<>();
//		 String CurrentLine;
//		 boolean Filter_data = false;
//		 int i = 0;
//		 //FileReader fr = new FileReader("C:\\NCDR_history\\auto\\Auto_1998-2007.txt");
//		 DataInputStream in = new DataInputStream(new FileInputStream(new File("C:\\NCDR_history\\auto\\Auto_1998-2007.txt")));
//		 BufferedReader br = new BufferedReader(new InputStreamReader(in,"MS950"));
//		 FileWriter fw = new FileWriter("C:\\NCDR_history\\auto\\Auto_1998-2007_10.txt");
//		 while ((CurrentLine = br.readLine()) != null) {
//		 System.out.println(CurrentLine);
//		 ResList.add(CurrentLine);
//		 fw.write(CurrentLine + "\r\n");
//		 i++;
//		 if(i>102){
//			 break;
//		 }
//		 }
//		 fw.flush();
//		 fw.close();
//		 in.close();
//		
//		//讀寫檔案用(CSV)
//		 List<String> ResList = new ArrayList<>();
//		 String CurrentLine;
//		 int i = 0;
//		 FileReader fr = new FileReader("C:\\NCDR_history\\weather\\Metro_2018\\201803.csv");
//		 DataInputStream in = 
//   				 new DataInputStream(
//   						 new FileInputStream(
//   								 new File("C:\\NCDR_history\\rainfall\\2018\\Rain_2018\\MetroRain_201801.csv")));
//   		 BufferedReader br = new BufferedReader(new InputStreamReader(in,"MS950"));
//		 FileWriter fw = new FileWriter("C:\\NCDR_history\\rainfall\\2018\\Rain_2018\\MetroRain_201801_1000.csv");
//		 while ((CurrentLine = br.readLine()) != null) {
//		 System.out.println(CurrentLine);
//		 ResList.add(CurrentLine);
//		 fw.write(CurrentLine+"\n");
//		 i++;
//		 if(i>1000){
//			 break;
//		 }
//		 }
//		 fw.flush();
//		 fw.close();
//		 in.close();
		 
		 //讀寫檔案用(txt)
		 //FileWriter fw = new FileWriter("C:\\NCDR_history\\weather\\Metro_1998-2017_10.txt");
		 //while ((CurrentLine = br.readLine()) != null) {
		 //if(CurrentLine.contains("# stno")){
		 //Filter_data = true;
		 //System.out.println(CurrentLine);
		 //}
		 //if(Filter_data == true){
		 //ResList.add(CurrentLine);
		 //}
		
		 //System.out.println(CurrentLine);
		 //fw.write(br.readLine()+"\n");
		 //i++;
		 //if(i>10){
		 //break;
		 //}
		 //}
//		 fw.flush();
//		 fw.close();
//		 //br.close();
//		 in.close();
		
		//測試讀檔函式(CSV)
//		GetMethod Get = new GetMethod();
//		List<String> ResList = Get.doGetStrList_2018();
//		String[] tmpSplitCol = ResList.get(1).split(",");
//		System.out.println("長度為："+tmpSplitCol.length);
//		for(int i=0; i<tmpSplitCol.length; i++){
//			tmpSplitCol[i] = tmpSplitCol[i].replace("\"", "");
//			if(tmpSplitCol[i].trim().isEmpty()){
//				//System.out.println("空的");
//				tmpSplitCol[i] = "0";
//			}
//			System.out.println(tmpSplitCol[i]);
//		}
//		WeatherController wc = new WeatherController();
//		System.out.println(tmpSplitCol[2]);
//		System.out.println(wc.DateFormat_yyyymmddhhmm(tmpSplitCol[2]));
		
		
//		//測試日期轉換
//		GetMethod Get = new GetMethod();
//		List<String> ResList = Get.doGetStrList_2();
//		String[] tmpSplitCol = ResList.get(1).split(",");
//		System.out.println(tmpSplitCol[0]);
//		WeatherController wc = new WeatherController();
//		tmpSplitCol[1] = wc.DateFormat_yyyymmddhh(tmpSplitCol[1]);
//		System.out.println(tmpSplitCol[1]);
		
//		SimpleDateFormat SDF = new SimpleDateFormat ("yyyymmddHH");
//		SDF.setLenient(false);
//		Date newDate = SDF.parse(tmpSplitCol[1]);
//		SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(SDF.format(newDate).toString());

		// System.out.println(tmpSplitCol.size());
//		for (String data : ResList) {
//			System.out.println(data);
//		}
		
//		//網址轉換
//		String ThingName = "氣象站_old-";
//		System.out.println(ThingName);
//		ThingName = URLEncoder.encode(ThingName,"UTF-8");
//		System.out.println(ThingName);
		
		//測試POST_THING檔案
//		 setPostThingObject("777","777","775","777","777","777","777","777","777","777","777","777","7","0","0","0");
//		 System.out.println(PostThingObject);
//		// System.out.println(ResList.get(1));
		
		//測試POST_DATA
		
//		String Date_addT[] = tmpSplitCol[1].split(" ");
//		for(int i=0; i<Date_addT.length; i++){
//			System.out.println(Date_addT[i]);
//		}
		
//		//測試日期換日加一天
//		WeatherController wc = new WeatherController();
//		tmpSplitCol[1] = wc.DateFormat_yyyymmddhh("2002010124");
//		System.out.println(tmpSplitCol[1]);
//		String RST_Date = tmpSplitCol[1].split(" ")[0]+"T"+tmpSplitCol[1].split(" ")[1];
//		String PS01 = tmpSplitCol[2];
//		String TX01 = tmpSplitCol[3];
//		String RH01 = tmpSplitCol[4];
//		String WD01 = tmpSplitCol[5];
//		String WD02 = tmpSplitCol[6];
//		String SS01 = tmpSplitCol[7];
		
//		GetMethod Get = new GetMethod();
//		List<String> TmpList = Get.doGetStrList_auto();
//		String[] tmpSplitCol = TmpList.get(0).split(",");
//		for(String data :tmpSplitCol){
//			System.out.println(data);
//		}
		
	}
}
