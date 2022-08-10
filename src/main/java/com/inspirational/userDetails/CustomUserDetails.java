package com.inspirational.userDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private int id;
	private String loginId;
	private String encryptedPassword;
	private String email;
	private String phoneNumber;
	private String authority;
	private String userNameInApp;
	private String realName;
	private Date createdAt;
	private Date updatedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(authority));
		return authorities;
	}

	@Override
	public String getPassword() {
		return encryptedPassword;
	}

	@Override
	public String getUsername() {
		return loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// getter ane setter
	 public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getLoginId() {
	        return loginId;
	    }
	    public void setLoginId(String loginId) {
	        this.loginId = loginId;
	    }
	    public String getEncryptedPassword() {
	        return encryptedPassword;
	    }
	    public void setEncryptedPassword(String encryptedPassword) {
	        this.encryptedPassword = encryptedPassword;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	    public String getAuthority() {
	        return authority;
	    }
	    public void setAuthority(String authority) {
	        this.authority = authority;
	    }
	    public String getUserNameInApp() {
	        return userNameInApp;
	    }
	    public void setUserNameInApp(String userNameInApp) {
	        this.userNameInApp = userNameInApp;
	    }
	    public String getRealName() {
	        return realName;
	    }
	    public void setRealName(String realName) {
	        this.realName = realName;
	    }
	    public Date getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }
	    public Date getUpdatedAt() {
	        return updatedAt;
	    }
	    public void setUpdatedAt(Date updatedAt) {
	        this.updatedAt = updatedAt;
	    }

}