package com.hellojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellojava.business.IUserService;
import com.hellojava.entity.UserView;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public String loginMapping() {
		return "login";
	}
	@RequestMapping("/loginHander")
	public String login(UserView userView ) {
		boolean bool=userService.query(userView);
		return bool?"upload":"login";
	}
}
