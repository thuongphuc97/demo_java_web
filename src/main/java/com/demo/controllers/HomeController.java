package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.User;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(ModelMap map, @RequestParam(name = "uid", required = false) String userid) {
		map.addAttribute("msg",userid);
		return "hello";
	}
	

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest req, @RequestParam(name = "uid", required = true) String userid) {
		
		User user = new User();
//		TODO get user from DB
		user.setName(userid);
//===============================
		
		req.setAttribute("user", user);
		return "add-user";	
	}
}
