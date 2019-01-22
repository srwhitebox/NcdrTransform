package com.mitac.NcdrTransform.methods;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.sf.json.JSONObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetMethod {
	private String Url;
	
	public GetMethod(String Url){
		this.Url = Url;
	}
	
	public GetMethod() {
		// TODO Auto-generated constructor stub
	}

	public JSONObject doGetJson(){
        try {
        	InputStream is = new URL(Url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8")); //避免中文亂碼問題
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = br.read()) != -1) {
                sb.append((char) cp);
            }
            JSONObject json = JSONObject.fromObject(sb.toString());
            is.close();
            return json;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList(){
        try {
        	List<String> ResList = new ArrayList<>();
        	InputStream is = new URL(Url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8")); //避免中文亂碼問題
            String CurrentLine;
            while ((CurrentLine = br.readLine()) != null) {
            	ResList.add(CurrentLine);
            }
            is.close();
            return ResList;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList_2(){
        try {
        	List<String> ResList = new ArrayList<>();
    		String CurrentLine;
    		boolean Filter_data = false;
    		//int i = 0;
    		FileReader fr = new FileReader("C:\\NCDR_history\\weather\\Metro_1998-2017_10.txt");
    		BufferedReader br = new BufferedReader(fr);
    		while ((CurrentLine = br.readLine()) != null) {
    			if(CurrentLine.contains("# stno")){
    				Filter_data = true;
    			}
    			if(Filter_data == true){
    				ResList.add(CurrentLine);
    			}
    		}
    		fr.close();
    		List<String> tmpSplitCol = new ArrayList<>();
    		String dataAdd = "";
    		for (int j = 0; j < ResList.size(); j++) {
    			String[] tmpSplitCol_full = ResList.get(j).split(" ");
    			// System.out.println(tmpSplitCol_full[4].trim());
    			for (String data : tmpSplitCol_full) {
    				if (!data.trim().isEmpty() && !data.trim().equals("#")) {
    					dataAdd = dataAdd + data + ",";
    				}
    			}
    			tmpSplitCol.add(dataAdd.substring(0, dataAdd.length() - 1));
    			dataAdd = "";
    		}
            return tmpSplitCol;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList_2018(){
        try {
         List<String> ResList = new ArrayList<>();
   		 String CurrentLine;
   		 DataInputStream in = 
   				 new DataInputStream(
   						 new FileInputStream(
   								 new File("C:\\NCDR_history\\weather\\Metro_2018\\201803_10.csv")));
   		 BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
   		 while ((CurrentLine = br.readLine()) != null) {
   		 ResList.add(CurrentLine);
   		 }
		 in.close();
            return ResList;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList_auto(){
        try {
        	List<String> ResList = new ArrayList<>();
    		String CurrentLine;
    		boolean Filter_data = false;
    		//int i = 0;
    		FileReader fr = new FileReader("C:\\NCDR_history\\auto\\Auto_1998-2007_10.txt");
    		BufferedReader br = new BufferedReader(fr);
    		while ((CurrentLine = br.readLine()) != null) {
    			if(CurrentLine.contains("# stno")){
    				Filter_data = true;
    			}
    			if(Filter_data == true){
    				ResList.add(CurrentLine);
    			}
    		}
    		fr.close();
    		List<String> tmpSplitCol = new ArrayList<>();
    		String dataAdd = "";
    		for (int j = 0; j < ResList.size(); j++) {
    			String[] tmpSplitCol_full = ResList.get(j).split(" ");
    			// System.out.println(tmpSplitCol_full[4].trim());
    			for (String data : tmpSplitCol_full) {
    				if (!data.trim().isEmpty() && !data.trim().equals("#")) {
    					dataAdd = dataAdd + data + ",";
    				}
    			}
    			tmpSplitCol.add(dataAdd.substring(0, dataAdd.length() - 1));
    			dataAdd = "";
    		}
            return tmpSplitCol;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList_rainfall(){
        try {
        	List<String> ResList = new ArrayList<>();
    		String CurrentLine;
    		boolean Filter_data = false;
    		//int i = 0;
    		FileReader fr = new FileReader("C:\\NCDR_history\\rainfall\\Rain_1998-2017_10.txt");
    		BufferedReader br = new BufferedReader(fr);
    		while ((CurrentLine = br.readLine()) != null) {
    			if(CurrentLine.contains("# stno")){
    				Filter_data = true;
    			}
    			if(Filter_data == true){
    				ResList.add(CurrentLine);
    			}
    		}
    		fr.close();
    		List<String> tmpSplitCol = new ArrayList<>();
    		String dataAdd = "";
    		for (int j = 0; j < ResList.size(); j++) {
    			String[] tmpSplitCol_full = ResList.get(j).split(" ");
    			// System.out.println(tmpSplitCol_full[4].trim());
    			for (String data : tmpSplitCol_full) {
    				if (!data.trim().isEmpty() && !data.trim().equals("#")) {
    					dataAdd = dataAdd + data + ",";
    				}
    			}
    			tmpSplitCol.add(dataAdd.substring(0, dataAdd.length() - 1));
    			dataAdd = "";
    		}
            return tmpSplitCol;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<String> doGetStrList_rainfall_2018(){
        try {
         List<String> ResList = new ArrayList<>();
   		 String CurrentLine;
   		 DataInputStream in = 
   				 new DataInputStream(
   						 new FileInputStream(
   								 new File("C:\\NCDR_history\\rainfall\\2018\\Rain_2018\\MetroRain_201801_10.csv")));
   		 BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
   		 while ((CurrentLine = br.readLine()) != null) {
   		 ResList.add(CurrentLine);
   		 }
		 in.close();
            return ResList;
        }
        catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
