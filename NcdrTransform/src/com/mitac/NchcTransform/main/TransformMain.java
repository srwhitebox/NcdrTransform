package com.mitac.NchcTransform.main;

import com.mitac.NchcTransform.Rainfall.*;
import com.mitac.NchcTransform.Weather.*;

public class TransformMain {

	public static void main(String[] args) {
		String UsageStr = "Usage: java -jar NcdrTransform.jar [MainClass] [SensorthingServerUrl] [Option] [DataType]\nOption:\n-C, To create Things.\n-U, To update observations.\n\nDataType:\n全部資料:ALL,\nCCTV:CCTV,\n水位站:WaterLevel,\n雨量站:Rainfall,\n氣象站:Weather";
		if(args.length<4) {
			System.out.println(UsageStr);
			return;
		}
		String Path = null;
		String OgcServerBaseUrl = args[1];
		//String OgcServerBaseUrl = "http://10.11.10.61:8080/FROST-Server/v1.0";
		String Op = args[2];
		//String Op = "-C";
		//String Op = "-U";
		String DataType = args[3];
		//String DataType = "ALL";
		//String DataType = "WaterLevel";
		if(!DataType.equals("F")&&!DataType.equals("G")&&!DataType.equals("H"))
		Path = args[4];
		
		
		//initialize
		//WaterLevelController WL_Controller = new WaterLevelController(OgcServerBaseUrl);
		//ReservoirWaterLevelController RWL_Controller = new ReservoirWaterLevelController(OgcServerBaseUrl);
		RainfallController RF_Controller = new RainfallController(OgcServerBaseUrl);
		RainfallController_csv RF_Controller_csv = new RainfallController_csv(OgcServerBaseUrl);
		RainfallController_realtime RF_Controller_realtime = new RainfallController_realtime(OgcServerBaseUrl);
		//CctvController CCTV_Controller = new CctvController(OgcServerBaseUrl);
		WeatherController WHR_Controller = new WeatherController(OgcServerBaseUrl);
		WeatherController_txt WHR_Controller_txt = new WeatherController_txt(OgcServerBaseUrl);
		WeatherController_csv WHR_Controller_csv = new WeatherController_csv(OgcServerBaseUrl);
		WeatherController_auto WHR_Controller_auto = new WeatherController_auto(OgcServerBaseUrl);
		WeatherController_realtime WHR_Controller_realtime = new WeatherController_realtime(OgcServerBaseUrl);
		//WeatherController_auto WHR_Controller_auto = new WeatherController_auto(OgcServerBaseUrl);
		
		if(Op.equals("-C")) {
			System.out.print("Creating ");
			if(DataType.equals("ALL")) {
				System.out.println("ALL...");
				//CCTV_Controller.CreateThing();
				//WL_Controller.CreateThing();
				//RWL_Controller.CreateThing();
				//RF_Controller.UpdateThing();
				WHR_Controller.UpdateThing();
			}
			else if(DataType.equals("CCTV")) {
				System.out.println("CCTV...");
				//CCTV_Controller.CreateThing();
			}
			else if(DataType.equals("WaterLevel")) {
				System.out.println("WaterLevel...");
				//WL_Controller.CreateThing();
				//RWL_Controller.CreateThing();
			}
			else if(DataType.equals("Rainfall")) {
				System.out.println("Rainfall...");
				//RF_Controller.UpdateThing();
			}
			else {
				System.out.println("Error:");
				System.out.println(UsageStr);
				return;
			}
			System.out.println("Done.");
		}
		else if(Op.equals("-U")){
			System.out.print("Updating ");
			if(DataType.equals("A")) {
				System.out.println("局屬氣象站(txt)");
				WHR_Controller_txt.UpdateThing(Path);
			}
			else if(DataType.equals("B")) {
				System.out.println("局屬氣象站(2018_csv)");
				WHR_Controller_csv.UpdateThing(Path);
			}
			else if(DataType.equals("C")) {
				System.out.println("自動氣象站(txt)");
				WHR_Controller_auto.UpdateThing(Path);
			}
			else if(DataType.equals("D")) {
				System.out.println("雨量站(txt)");
				RF_Controller.UpdateThing(Path);
			}
			else if(DataType.equals("E")) {
				System.out.println("雨量站(csv)");
				RF_Controller_csv.UpdateThing(Path);
			}
			else if(DataType.equals("F")) {
				System.out.println("即時資料(自動氣象站-氣象觀測資料)");
				WHR_Controller_realtime.UpdateThing();
			}
			else if(DataType.equals("G")) {
				System.out.println("即時資料(局屬氣象站-現在天氣觀測報告)");
				WHR_Controller.UpdateThing();
			}
			else if(DataType.equals("H")) {
				System.out.println("即時資料(自動雨量站-雨量觀測資料)");
				RF_Controller_realtime.UpdateThing();
			}
			else {
				System.out.println("Error:");
				System.out.println(UsageStr);
				return;
			}
			System.out.println("Done.");
		}
		else {
			System.out.println(UsageStr);
			return;
		}
	}

}
