package com.mitac.NcdrTransform.methods;

import java.io.BufferedReader;
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
}
