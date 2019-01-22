package com.mitac.NcdrTransform.main;

import com.mitac.NcdrTransform.Rainfall.*;
import com.mitac.NcdrTransform.ReservoirWaterLevel.ReservoirWaterLevelController;
import com.mitac.NcdrTransform.WaterLevel.*;
import com.mitac.NcdrTransform.Weather.WeatherController;
import com.mitac.NcdrTransform.CCTV.*;

public class TransformMain {

	public static void main(String[] args) {
		String UsageStr = "Usage: java -jar NcdrTransform.jar [MainClass] [SensorthingServerUrl] [Option] [DataType]\nOption:\n-C, To create Things.\n-U, To update observations.\n\nDataType:\n全部資料:ALL,\nCCTV:CCTV,\n水位站:WaterLevel,\n雨量站:Rainfall,\n氣象站:Weather";
		if(args.length<4) {
			System.out.println(UsageStr);
			return;
		}
		String OgcServerBaseUrl = args[1];
		//String OgcServerBaseUrl = "http://10.11.10.61:8080/FROST-Server/v1.0";
		String Op = args[2];
		//String Op = "-C";
		//String Op = "-U";
		String DataType = args[3];
		//String DataType = "ALL";
		//String DataType = "WaterLevel";
		
		//initialize
		WaterLevelController WL_Controller = new WaterLevelController(OgcServerBaseUrl);
		ReservoirWaterLevelController RWL_Controller = new ReservoirWaterLevelController(OgcServerBaseUrl);
		RainfallController RF_Controller = new RainfallController(OgcServerBaseUrl);
		CctvController CCTV_Controller = new CctvController(OgcServerBaseUrl);
		WeatherController WHR_Controller = new WeatherController(OgcServerBaseUrl);
		
		if(Op.equals("-C")) {
			System.out.print("Creating ");
			if(DataType.equals("ALL")) {
				System.out.println("ALL...");
				CCTV_Controller.CreateThing();
				WL_Controller.CreateThing();
				RWL_Controller.CreateThing();
				RF_Controller.UpdateThing();
				WHR_Controller.UpdateThing();
			}
			else if(DataType.equals("CCTV")) {
				System.out.println("CCTV...");
				CCTV_Controller.CreateThing();
			}
			else if(DataType.equals("WaterLevel")) {
				System.out.println("WaterLevel...");
				WL_Controller.CreateThing();
				RWL_Controller.CreateThing();
			}
			else if(DataType.equals("Rainfall")) {
				System.out.println("Rainfall...");
				RF_Controller.UpdateThing();
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
			if(DataType.equals("ALL")) {
				System.out.println("ALL...");
				WL_Controller.UpdateThing();
				RWL_Controller.UpdateThing();
				RF_Controller.UpdateThing();
				WHR_Controller.UpdateThing();
			}
			else if(DataType.equals("WaterLevel")) {
				System.out.println("WaterLevel...");
				WL_Controller.UpdateThing();
				RWL_Controller.UpdateThing();
			}
			else if(DataType.equals("Rainfall")) {
				System.out.println("Rainfall...");
				RF_Controller.UpdateThing();
			}
			else if(DataType.equals("Weather")) {
				System.out.println("Weather...");
				WHR_Controller.UpdateThing();
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
