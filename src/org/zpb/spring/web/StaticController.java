package org.zpb.spring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class StaticController extends MultiActionController {

	public ModelAndView img(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}
	
}
