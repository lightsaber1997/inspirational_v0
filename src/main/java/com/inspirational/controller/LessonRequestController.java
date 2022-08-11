package com.inspirational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspirational.grade.Grade;
import com.inspirational.grade.GradeBO;
import com.inspirational.subject.Subject;
import com.inspirational.subject.SubjectBO;

@RequestMapping("/lesson_request")
@Controller
public class LessonRequestController {
	@Autowired
	private SubjectBO subejctBo;
	@Autowired
	private GradeBO gradeBO;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("viewName", "lesson_request/index");
		return "template/layout";
	}
	
	@RequestMapping("/create_view")
	public String createView(Model model) {
		List<Subject> listSubject = subejctBo.selectAll();
		List<Grade> listGrade = gradeBO.selectAll();
		model.addAttribute("listSubject", listSubject);
		model.addAttribute("listGrade", listGrade);
		
		model.addAttribute("viewName", "lesson_request/create_view");
		model.addAttribute("css_file", "/static/css/lesson_request/style.css");
		return "template/layout";
	}
}
