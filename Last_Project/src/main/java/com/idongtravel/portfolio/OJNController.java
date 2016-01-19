package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OJNController {

	@RequestMapping("/weather")
	public String weather(HttpServletRequest request) {
		return "travelInfo/weather";
	}
	
	@RequestMapping("/koreaInfo")
	public String koreaInfo(HttpServletRequest request) {
		return "travelInfo/koreaInfo";
	}
}
