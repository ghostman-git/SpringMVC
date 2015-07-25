package org.zpb.spring.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zpb.spring.entity.User;

@Controller
public class AjaxController {
	
	@RequestMapping(value="ajax",method=RequestMethod.GET)
	public @ResponseBody List<User> ajax(String name) {
		List<User> lst = new ArrayList<User>();
		lst.add(new User());
		lst.add(new User());
		return lst;
	}
	
}
