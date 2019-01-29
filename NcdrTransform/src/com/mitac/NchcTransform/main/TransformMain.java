package com.mitac.NchcTransform.main;

import java.io.File;

import com.mitac.NchcTransform.Rainfall.*;
import com.mitac.NchcTransform.Weather.*;

public class TransformMain {

	public static void main(String[] args) {
		String UsageStr = "Usage: java -jar NcdrTransform.jar [MainClass] [SensorthingServerUrl] [Option] [DataType] [FilePath/FolderPath]\nOption:\n-U, To update Observations or create Thing.\n\nDataType:\nA: 歷史資料-局屬氣象站(1998-2017)\r\n" + 
				"B: 歷史資料-局屬氣象站(2018)\r\n" + 
				"C: 歷史資料-自動氣象站(1998-2007、2008-2018)\r\n" + 
				"D: 歷史資料-雨量站(1998-2017)\r\n" + 
				"E: 歷史資料-雨量站(2018)\r\n" + 
				"F: 即時資料-自動氣象站-氣象觀測資料\r\n" + 
				"G: 即時資料-局屬氣象站-現在天氣觀測報告\r\n" + 
				"H: 即時資料-自動雨量站-雨量觀測資料";
		if(args.length<4) {
			System.out.println(UsageStr);
			return;
		}
		String Path = null;
		String OgcServerBaseUrl = args[1];
		String Op = args[2];
		String DataType = args[3];
		if(!DataType.equals("F")&&!DataType.equals("G")&&!DataType.equals("H")) {
			Path = args[4];
		}
		
		
		//initialize
		RainfallController RF_Controller = new RainfallController(OgcServerBaseUrl);
		RainfallController_csv RF_Controller_csv = new RainfallController_csv(OgcServerBaseUrl);
		RainfallController_realtime RF_Controller_realtime = new RainfallController_realtime(OgcServerBaseUrl);
		WeatherController WHR_Controller = new WeatherController(OgcServerBaseUrl);
		WeatherController_txt WHR_Controller_txt = new WeatherController_txt(OgcServerBaseUrl);
		WeatherController_csv WHR_Controller_csv = new WeatherController_csv(OgcServerBaseUrl);
		WeatherController_auto WHR_Controller_auto = new WeatherController_auto(OgcServerBaseUrl);
		WeatherController_realtime WHR_Controller_realtime = new WeatherController_realtime(OgcServerBaseUrl);
		
		if(Op.equals("-U")){
			System.out.print("Updating ");
			if(DataType.equals("A")) {
				System.out.println("局屬氣象站(txt)");
				WHR_Controller_txt.UpdateThing(Path);
			}
			else if(DataType.equals("B")) {
				System.out.println("局屬氣象站(2018_csv)");
				try{
					File FolderPath = new File(Path);
					File[] listOfFiles = FolderPath.listFiles();
					for (File f : listOfFiles) {
						WHR_Controller_csv.UpdateThing(f.getPath());
					}
				}catch(Exception e) {
			    	e.printStackTrace();
			    }
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
				try{
					File FolderPath = new File(Path);
					File[] listOfFiles = FolderPath.listFiles();
					for (File f : listOfFiles) {
						RF_Controller_csv.UpdateThing(f.getPath());
					}
				}catch(Exception e) {
			    	e.printStackTrace();
			    }
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
