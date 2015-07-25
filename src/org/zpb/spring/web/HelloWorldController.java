package org.zpb.spring.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("handleRequest……");
//		String hello = "hello 小波";
//		return new ModelAndView("index", "str", hello);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "小波");
		map.put("age", 23);
		map.put("city", "烟台");
		return new ModelAndView("index", "map", map);
	}

}
