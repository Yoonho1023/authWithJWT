package com.login.app.auth.entity;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.login.app.metadata.domain.model.user.User;
import com.login.app.metadata.domain.service.UserAuthentication;

public class AuthenticationContext {

	public static Optional<User> getCurrentEmployee() {
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}
		final UserAuthentication authentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return Optional.empty();
		}

		User user = authentication.getUser();
		return Optional.ofNullable(user);
	}
}
