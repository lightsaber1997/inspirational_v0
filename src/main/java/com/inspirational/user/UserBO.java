package com.inspirational.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<User> selectUserList() {
		return userDAO.selectUserList();
	}
	
	public User selectUserById(
			int id) {
		return userDAO.selectUserById(id);
	}
	
	public User selectUserByLoginId(
			String loginId) {
		return userDAO.selectUserByLoginId(loginId);
	}
	
	public User selectUserByUserNameInApp(
			String userNameInApp) {
		return userDAO.selectUserByUserNameInApp(userNameInApp);
	}

	public void insertUser(
			String loginId, String password, String email, 
			String phoneNumber, String authority, 
			String userNameInApp, String realName
			) {
		if (!(authority.equals("student") || 
				authority.equals("instructor"))) {
			throw new IllegalArgumentException();
		}
		String encryptedPassword = passwordEncoder.encode(password);
		
		userDAO.insertUser(loginId, encryptedPassword, email, phoneNumber, authority, userNameInApp, realName);
		
	}
}
