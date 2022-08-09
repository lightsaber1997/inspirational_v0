package com.inspirational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstPageController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("viewName", "firstPage/index");
		return "template/layout";
	}
}
