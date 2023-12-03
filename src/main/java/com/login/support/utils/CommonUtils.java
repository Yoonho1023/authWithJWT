package com.login.support.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonUtils {

	/**
	 * 비밀번호 해싱용.
	 * TODO Bcrypt로 변경 도전
	 */
	public static String sha512(String text) {
		String res = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.reset();
			md.update(text.getBytes("utf8"));
			res = String.format("%0128x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("Exception while sha512 hashing. message: {}", e.getMessage());
		}
		return res;
	}
}
