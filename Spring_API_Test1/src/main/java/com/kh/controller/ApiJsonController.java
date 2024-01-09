package com.kh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiJsonController {
	@GetMapping(value="/api/get", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String DBInsert(){
		//데이터를 시작하기 전에는 Stringbuilder
		StringBuilder result = new StringBuilder();
		try {
			String apiUrl = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst";
			String apiKey = "OztGXpvsHLhffRFWL3CXGC0gKzWpr6979sATWZ%2FlJWYKAfDQbFCQ%2FrNaOw4kKpBF7AiCjDWMc%2FlMFFHc%2FYvolQ%3D%3D"; //encode
			
			String pageNo ="1";
			String numOfRows="10";
			String dataType="xml";
			String stnId="108";
			String tmFc="202401090600";
			String encodedApiKey=URLEncoder.encode(apiKey, "UTF-8");
			String encodedUrl=String.format("%s?serviceKey=%s&pageNo=%s&numOfRows=%s&dataType=%s&stnId=%s&tmFc=%s",
                    apiUrl, encodedApiKey, numOfRows, pageNo, dataType, stnId, tmFc);		
			
			URL url = new URL(encodedUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		//화면에 데이터가 출력될 수 있도록 readLine을 써서 출력
			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			connection.disconnect();
			//데이터베이스에 저장하는 메서드 실행 
			
		}catch(Exception err) {
			err.printStackTrace();
		}
		
	
	
		//json파일로 변환해서 보여주기
		String jsonResult = convertXmlToJson(result.toString());
		return jsonResult;
		
	}
	//xml로 보이는 파일을 json형식으로 변환해서 화면에 출력하는 메서드 
	private String convertXmlToJson(String xmlData) {
		JSONObject jsonObj = XML.toJSONObject(xmlData);
		return jsonObj.toString();
		
	}

}
