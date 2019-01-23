package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mitac.NchcTransform.methods.GetMethod;
import com.mitac.NchcTransform.methods.PostMethod;
import com.mitac.NchcTransform.Weather.WeatherThingJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NewTestForEd {

	private String ServerUrlBase;
	private final static String CreateNcdrType = "GaugeStation";
	private final static String CreateNcdrUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Sensor/JsonGaugeStation.txt";
	// private final String UpdateNcdrType = "Realtime_vCWB_nGauge_1DayJSON";
	// private final String UpdateNcdrUrl =
	// "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/JSON/Gauge/GaugeJson.txt";
	Date date = new Date();

	SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHH00");
	// private String CreateAndUpdateUrl =
	// "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/QPESUMS/AST_LST/AST_"+SDF.format(date)+".csv";
	private static String CreateAndUpdateUrl = "http://ncdrfile.ncdr.nat.gov.tw/filestorage/INTERFACING/NCDR/QPESUMS/AST_LST/AST_201809260800.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get weather update stid array
				GetMethod Get = new GetMethod(CreateAndUpdateUrl);
				List<String> TmpList = Get.doGetStrList();
				List<String> TmpList_2 = Get.doGetStrList_2("");
				//--- get rainfall station info start ---
				GetMethod GetRain = new GetMethod(CreateNcdrUrl);
				JSONObject GetJson = GetRain.doGetJson();//Get Json from UpdateNcdrUrl
//				String RST_DATE = GetJson.getString("Rst_date");
				JSONArray GetJsonArr = GetJson.getJSONArray(CreateNcdrType);
				//--- get rainfall station info end ---
//				String[] tmpSplitCol = TmpList.get(1).split(",");
//				WeatherThingJson WHR_json = new WeatherThingJson();
//				PostMethod Post = new PostMethod();
//				JSONObject tmp = null;
//				for(int j=0;j<GetJsonArr.size();j++) {
//					tmp = JSONObject.fromObject(GetJsonArr.get(j));
//					if(tmpSplitCol[0].equals(tmp.getString("STID"))) { //find it, break
//						System.out.println("����");
//						break;
//					}
//				}
//				System.out.println("����");
//				System.out.println(tmpSplitCol[1]);
//				System.out.println("Weather Update size: "+(TmpList.size()-1));
				
//				int ColNum=0;
//				int ColNum_2=0;
//				String[] tmpSplitCol_123 = TmpList.get(1).split(",");
//				for (String data : TmpList) {
//					System.out.println(data);
//					ColNum++;
//					if(ColNum>2)
//						break;
//				}
//				
//				for (String data : TmpList_2) {
//					System.out.println(data);
//					ColNum_2++;
//					if(ColNum_2>2)
//						break;
//				}
				String[] tmpSplitCol_2 = TmpList_2.get(2).split(",");
				for(String data : tmpSplitCol_2){
					System.out.println(data);
				}
//				for(int i=0;i<TmpList.size();i++) {//TmpList.size()
//					String[] tmpSplitCol = TmpList.get(i).split(",");
//					if(i==0) {
//						ColNum = tmpSplitCol.length;
//					}
//				}
	}
}
