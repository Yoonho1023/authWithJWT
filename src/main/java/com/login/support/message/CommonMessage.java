package com.login.support.message;

import lombok.Getter;

@Getter
public enum CommonMessage {

	MOBILE("mobile");

	private String value;

	CommonMessage(String value) {
		this.value = value;
	}
}
