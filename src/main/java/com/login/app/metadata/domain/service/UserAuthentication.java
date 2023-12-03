package com.login.app.metadata.domain.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.login.app.metadata.domain.model.user.User;

import lombok.Getter;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {

	@Getter
	private User user;

	public UserAuthentication(User emp, String credentials, List<GrantedAuthority> authorities) {
		super(emp.getUserId(), credentials, authorities);
		this.user = emp;
	}
}

