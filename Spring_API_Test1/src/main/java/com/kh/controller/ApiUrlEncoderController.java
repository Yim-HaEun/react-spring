package com.kh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUrlEncoderController {
	@GetMapping("/api/encoder/data")
	public String allowBasic() {
		StringBuffer result = new StringBuffer();
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B550928/dissForecastInfoSvc");
		urlBuilder.append("?ServiceKey=OztGXpvsHLhffRFWL3CXGC0gKzWpr6979sATWZ%2FlJWYKAfDQbFCQ%2FrNaOw4kKpBF7AiCjDWMc%2FlMFFHc%2FYvolQ%3D%3D");
		urlBuilder.append("&pageNo=1");
		urlBuilder.append("&numOfRows=10");
		urlBuilder.append("&type=json");
		//결과로 보여줄 포맷 만약 xml로 보여주고싶다면 xml로 설정
		 
	
		try {
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd;
			
			//만약에 response코드가 200보다 크거나 300보다 작을 때
			//Http: 응답코드가 200~299 사이는 성공 / 응답코드가 300~399 redirection
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode()<=300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			}else {//실패했을 경우
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				
			}
			String line;
			while((line =rd.readLine()) != null) {
				result.append(line).append("\n");
				
			}
			rd.close();
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
		
		
		
	}

}
