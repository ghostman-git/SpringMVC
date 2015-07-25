package org.zpb.spring.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zpb.spring.entity.User;

@Controller
@RequestMapping("user")
@SessionAttributes({"name","b"})
public class UserController {
	
	/*
	 * ,method=RequestMethod.GET 不写method，这样GET，POST方法都能访问
	 * value= 也可以不写value
	 */
	@RequestMapping("/register")
//	public ModelAndView register() {
//		return new ModelAndView("annotation","result","this is register");
//	}
//	public String register(HttpServletRequest request, String username, int age) {
//		request.setAttribute("result", "this is register");
//		System.out.println("[username]"+username+",[age]"+age);
//		return "annotation";
//	}
	public void register(HttpServletRequest request, HttpServletResponse response, User user) {
		request.setAttribute("result", "this is register");
		//{"username":"userName","age","age"}
		String result = "{\"username\":\" "+ user.getUsername() +" \",\"age\":\" "+ user.getAge()+" \"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public ModelAndView login() {
//		return new ModelAndView("annotation","result","this is login");
//	}
	
	public ModelAndView login(@RequestParam("username")String name, ModelMap model) {
		System.out.println("[name]"+name);
		model.put("name", name);
		model.addAttribute("b","BBBB");
		return new ModelAndView("annotation","result","this is login");
	}
	// 直接将session中的值赋值给name
//	public String login(@ModelAttribute("name")String name, ModelMap model) {
//		System.out.println("[name]"+name);
//		model.put("name", name);
//		model.addAttribute("b","BBBB");
//		//return new ModelAndView("annotation","result","this is login");
//		return "redirect:http://www.baidu.com";
//	}
	
	
	//支持参数k,p,s，其中k是关键词，[\w\W]标示任意字符，这是我以前调用java正则的时候学到的一招，非常的强大，非常magic的写法.p是分页，s是排序
	@RequestMapping(value = { "share/k{k:[\\w\\W]+}-p{p:\\d+}-s{s:\\d+}" }, method = { RequestMethod.GET })
	public String shareSearchPSK(@PathVariable Integer p, @PathVariable Integer s, @PathVariable String k, ModelMap model) {
//		Page<Project> projects = projectService.findAllByTitleOrTagsAndType(k, 
//				ModuleConstants.PROJECT_TYPE_SHARE_CODE, p, ParamConstants.DEFAULT_COUNT);
//		model.put("projects", projects);
//		model.put("key", k);
//		populateTopDatas(model);
		return "project/share/search";
	}
	//请求实例如下：http://www.zuidaima.com/share/k%E6%9C%80%E4%BB%A3%E7%A0%81-p1-s1.htm
}
