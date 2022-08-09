package com.inspirational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/sign_up_view")
	public String signUpView(Model model) {
		model.addAttribute("mainCss", "/static/css/sign_up_view/style.css");
		model.addAttribute("viewName", "user/sign_up_view");
		return "template/layout_sign_in";
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView(Model model) {
		model.addAttribute("mainCss", "/static/css/sign_up_view/style.css");
		model.addAttribute("viewName", "user/sign_in_view");
		return "template/layout_sign_in";
	}
	
	
}
