package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage() {
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
		
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logoutPage() {
		
		ModelAndView mv = new ModelAndView("product");
		return mv;
		
	}
}
