package com.inspirational.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private CustomUserDetailsDAO customUserDetailsDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails customUserDetails = 
				customUserDetailsDAO.selectUserByLoginId(username);
		if (customUserDetails == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println(customUserDetails.getEncryptedPassword());
		return customUserDetails;
	}
}
