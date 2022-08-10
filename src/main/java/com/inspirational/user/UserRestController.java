package com.inspirational.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspirational.studentProfile.StudentProfile;
import com.inspirational.studentProfile.studentProfileBO;
import com.inspirational.userDetails.CustomUserDetails;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private studentProfileBO studentProfileBO;
	
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="phoneNumber", required=false) String phoneNumber,
			@RequestParam("authority") String authority,
			@RequestParam("userNameInApp") String userNameInApp,
			@RequestParam(value="realName", required=false) String realName) {
		Map<String, Object> result = new HashMap<>();
		try {
			User user = userBO.selectUserByLoginId(loginId);
			
			if (user != null) {
				throw new Exception();
			}
			
			userBO.insertUser(loginId, password, email, phoneNumber, authority, userNameInApp, realName);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
		}
		
		return result;
	}	
	
	@PostMapping("/student/profile/update")
	public Map<String, Object> studentProfileUpdate(
			@RequestParam("content") String content,
			Authentication authentication) {
		
		
		Map<String, Object> result = new HashMap<>();
		try {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			int userId = userDetails.getId();
			
			// if there is no profile in the database
			// create a new row
			StudentProfile studentProfile = studentProfileBO.selectByStudentId(userId);
			if (studentProfile == null) {
				studentProfileBO.insert(userId, content);
			}
			
			else {
				studentProfileBO.updateByStudentId(userId, content);
			}
			
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
		}
		return result;

	}
}
