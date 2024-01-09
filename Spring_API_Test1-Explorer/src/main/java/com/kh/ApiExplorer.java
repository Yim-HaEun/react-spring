package com.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiExplorer {
	 public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B550928/dissForecastInfoSvc/getDissForecastInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=65liqYkK%2F8aC6Rh048XPwFgemJxH%2BMbwP3xXZX99CvFgz0Fu4q%2BdhC5NIQlLfrLVjpnKo8xX6yALLyPhICI0HQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호, 미입력 시 기본값 1*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*응답결과의 출력 방식(xml, json), 미입력시 기본값:xml*/
	        urlBuilder.append("&" + URLEncoder.encode("dissCd","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*질병코드*/
	        urlBuilder.append("&" + URLEncoder.encode("znCd","UTF-8") + "=" + URLEncoder.encode("11", "UTF-8")); /*시도별 지역코드, 지역코드 입력시 시군구별 데이터 응답/미입력시, 전국 및 시도별 데이터 응답*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}