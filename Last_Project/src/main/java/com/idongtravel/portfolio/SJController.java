package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SJController {
	@RequestMapping("/busancatelog")
	public String busancatelog(HttpServletRequest request) {
		return "travelpackage/Busan/busancatelog";
	}
	@RequestMapping("/gwanganbridge")
	public String gwanganbridge(HttpServletRequest request) {
		return "travelpackage/Busan/busandata/gwanganbridge";
	}
	@RequestMapping("/seoulcatalog")
	public String seoulcatelog(HttpServletRequest request) {
		return "travelpackage/Seoul/seoulcatalog";
	}
	@RequestMapping("/namsan")
	public String namsan(HttpServletRequest request) {
		return "travelpackage/Seoul/seouldata/namsan";
	}

}
