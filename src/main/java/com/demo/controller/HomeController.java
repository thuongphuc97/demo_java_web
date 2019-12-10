package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.User;

@Controller
public class HomeController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(ModelMap map, @RequestParam(name = "uid", required = false) String userid) {
		map.addAttribute("msg", userid);
		return "hello";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest req) {
		User user = new User();
//		TODO get user from DB
		user.setName("dadasd");
//===============================
		req.setAttribute("user", user);
		return "add-user";
	}
		@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(HttpServletRequest req, @ModelAttribute("user") @Valid User user, BindingResult bindingResult ) {
			if(bindingResult.hasErrors()) {
		
//				TODO get user from DB
				user.setName("dadasd");
		//===============================
				req.setAttribute("user", user);
				return "add-user";
			}
		req.setAttribute("user", user);
		return "view-user";
	}
}
