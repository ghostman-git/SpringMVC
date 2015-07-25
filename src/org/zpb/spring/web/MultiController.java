package org.zpb.spring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiController extends MultiActionController {

	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("MultiController.query()");
		return new ModelAndView("index");
	}
	
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("MultiController.update()");
		return new ModelAndView("index");
	}
	
}
