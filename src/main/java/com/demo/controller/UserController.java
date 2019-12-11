package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user/**")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value = {"/list-user"}, method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest req) {
		List<User> list = userService.getUserList();
		req.setAttribute("users", list);
		return "user/list-user";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest req) {
		User user = new User();
		req.setAttribute("user", user);
		return "user/add-user";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(HttpServletRequest req, @ModelAttribute("user") @Valid User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// ===============================
			req.setAttribute("user", user);
			return "user/add-user";
		}
		userService.addUser(user); // 
		req.setAttribute("user", user);
		return "user/view-user";
	}

	@RequestMapping(value = "/user-detail/{uid}")
	public String viewDetail(HttpServletRequest req, @PathVariable(name = "uid") String uid) {
		req.setAttribute("user", userService.getUserById(uid));
		return "user/view-user";
	}
	@RequestMapping(value = "/delete-user/{uid}",method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest req, @PathVariable(name = "uid") String uid) {
		userService.deleteUser(uid);	
		return "redirect:/user/list-user";
	}
}
