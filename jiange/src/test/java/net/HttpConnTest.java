package net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpConnTest {

	public static void main(String[] args) throws IOException {
//		URL url = new URL("http://www.jd.com");
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.connect();
//		Map<String, List<String>> header = conn.getHeaderFields();
//		for (String key : header.keySet()) {
//			System.out.println(key + " : " +header.get(key));
//		}
//		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//		while(br.readLine() != null){
//			System.out.println(br.readLine());
//		}
//		conn.disconnect();
		
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"GBK"));
		while(br.readLine() != null){
			System.out.println(br.readLine());
		}
	}

}
