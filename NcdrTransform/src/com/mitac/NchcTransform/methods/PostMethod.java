package com.mitac.NchcTransform.methods;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostMethod {
	public PostMethod(){
	}
	
	public void doJsonPost(String Url,String Content){
		try{
	        URL endpoint = new URL(Url);
	        HttpURLConnection httpConnection = (HttpURLConnection) endpoint.openConnection();
	        httpConnection.setRequestMethod("POST");
	        httpConnection.setDoInput(true);
	        httpConnection.setDoOutput(true);
	        httpConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	        DataOutputStream outputStream = new DataOutputStream(httpConnection.getOutputStream());
	        outputStream.write(Content.toString().getBytes("UTF-8"));
	        outputStream.flush();
	        outputStream.close();
	        InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
	        BufferedReader br = new BufferedReader(isr);
	        String line = "";
	        while( (line = br.readLine()) != null ) {
	            System.out.println(line);
	        }
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(Content);
		}
	}
}
