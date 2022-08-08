package com.inspirational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class HelloController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("viewName", "hello/index");
		return "template/layout";
	}
}
