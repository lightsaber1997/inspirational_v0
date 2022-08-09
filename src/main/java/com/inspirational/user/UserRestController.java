package com.inspirational.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
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
			userBO.insertUser(loginId, password, email, phoneNumber, authority, userNameInApp, realName);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
		}
		
		return result;
	}	
}
