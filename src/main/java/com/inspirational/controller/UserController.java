package com.inspirational.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspirational.studentProfile.StudentProfile;
import com.inspirational.studentProfile.studentProfileBO;
import com.inspirational.user.User;
import com.inspirational.user.UserBO;
import com.inspirational.userDetails.CustomUserDetails;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private studentProfileBO studentProfileBO;
	
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
	
	@RequestMapping("/profile")
	public String profileRedirect(Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		String userNameInApp = userDetails.getUserNameInApp();
		String s = "redirect:/user/profile/" + userNameInApp;
		return s;
	}
	
	@RequestMapping("/profile/{userNameInApp}")
	public String profile(
			@PathVariable("userNameInApp") String userNameInApp,
			Model model,
			Authentication authentication) {
		User user = userBO.selectUserByUserNameInApp(userNameInApp);
		int userId = user.getId();
		
		StudentProfile studentProfile =  studentProfileBO.selectByStudentId(userId);
		
		boolean canEdit = false;
		try {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			if (userDetails.getUserNameInApp().equals(user.getUserNameInApp())) {
				canEdit = true;
			}
		} catch (Exception e) {
			
		}
		model.addAttribute("can_edit", canEdit);
		
		model.addAttribute("profile_user", user);
		if (user.getAuthority().equals("student")) {
			model.addAttribute("viewName", "user/profile_student");
		}
		model.addAttribute("studentProfile", studentProfile);
		
		model.addAttribute("css_file", "/static/css/student_profile_view/style.css");
		return "template/layout";
	}
	
	
	@RequestMapping("/profile/edit_view")
	public String editView(Authentication authentication, Model model) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		int userId = userDetails.getId();
		StudentProfile studentProfile = studentProfileBO.selectByStudentId(userId);
		StudentProfile studentProfile2 = new StudentProfile();
		if (studentProfile == null || studentProfile.getContent() == null) {
			studentProfile2.setContent("아직 작성된 내용이 없습니다. ");
		}
		else {
			studentProfile2.setContent(
					studentProfile.getContent());
		}
		
		model.addAttribute("studentProfile", studentProfile2);
		model.addAttribute("viewName", "user/profile_edit_view");
		model.addAttribute("css_file", "/static/css/student_profile_edit/style.css");
		return "template/layout";
	}
	
	
}
