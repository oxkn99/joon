package com.hyeok.joon.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	   @RequestMapping("/testLogin")
	    public String isComplete(HttpSession session) {
	        return "/naver/naverlogin";
	    }
	   @RequestMapping("/callback")
	    public String navLogin(HttpSession session) {
	        return "/naver/callback";
	    }
	   @RequestMapping(value = "/personalInfo")
	   public void personalInfo(HttpServletRequest request) throws Exception {
	           String token = "AAAANk9D6kosR5n6hTPXWJZ-ApYKV4aVCW6OIn0rQfiAdJKFDyM0dXAX_nr7XhHkEx8AAw_tCJOwMgRyNfV76LWBFQM";// 네이버 로그인 접근 토큰; 여기에 복사한 토큰값을 넣어줍니다.
	           String header = "Bearer " + token; // Bearer 다음에 공백 추가
	           try {
	               String apiURL = "https://openapi.naver.com/v1/nid/me";
	               URL url = new URL(apiURL);
	               HttpURLConnection con = (HttpURLConnection)url.openConnection();
	               con.setRequestMethod("GET");
	               con.setRequestProperty("Authorization", header);
	               int responseCode = con.getResponseCode();
	               BufferedReader br;
	               if(responseCode==200) { // 정상 호출
	                   br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	               } else {  // 에러 발생
	                   br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	               }
	               String inputLine;
	               StringBuffer response = new StringBuffer();
	               while ((inputLine = br.readLine()) != null) {
	                   response.append(inputLine);
	               }
	               br.close();
	               System.out.println(response.toString());
	           } catch (Exception e) {
	               System.out.println(e);
	           }
	   }
}
