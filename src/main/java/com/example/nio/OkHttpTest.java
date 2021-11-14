package com.example.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import org.apache.http.client.HttpClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {
	 public static OkHttpClient client = new OkHttpClient();
	 public static String getString(String url){
		 Request request = new Request.Builder().url(url).build();
		 Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
		 
		 
	 }
public static void main(String[] args) throws IOException {
	String url = "http://localhost:9801";
    String text = OkHttpTest.getString(url);
    System.out.println("url: " + url + " ; response: \n" + text);
    OkHttpTest.client = null;
}
}
