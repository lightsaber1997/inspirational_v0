package com.inspirational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspirational.subject.Subject;
import com.inspirational.subject.SubjectBO;

@RequestMapping("/lesson_request")
@Controller
public class LessonRequestController {
	@Autowired
	private SubjectBO subejctBo;
	
	@RequestMapping("/create_view")
	public String createView(Model model) {
		List<Subject> listSubject = subejctBo.selectAll();
		
		
		model.addAttribute("viewName", "lesson_request/create_view");
		model.addAttribute("css_file", "/static/css/lesson_request/style.css");
		return "template/layout";
	}
}
