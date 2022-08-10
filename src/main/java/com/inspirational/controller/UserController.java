package com.inspirational.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspirational.user.User;
import com.inspirational.user.UserBO;
import com.inspirational.userDetails.CustomUserDetails;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserBO userBO;
	
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
	
	@RequestMapping("/profile/{userNameInApp}")
	public String profile(
			@PathVariable("userNameInApp") String userNameInApp,
			Model model,
			Authentication authentication) {
		User user = userBO.selectUserByUserNameInApp(userNameInApp);
		
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
		model.addAttribute("css_file", "/static/css/student_profile_view/style.css");
		return "template/layout";
	}
	
	
	@RequestMapping("/profile/edit_view")
	public String editView(Model model) {
		model.addAttribute("viewName", "user/profile_edit_view");
		model.addAttribute("css_file", "/static/css/student_profile_edit/style.css");
		return "template/layout";
	}
	
	
}
