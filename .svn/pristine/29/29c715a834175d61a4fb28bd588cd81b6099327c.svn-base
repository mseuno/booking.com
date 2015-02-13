package com.epam.lab.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Validator {

	USER_LOGIN("[A-Za-z0-9]{4,16}$"), USER_EMAIL(
			"^([0-9a-zA-Z]+[-._+&amp;])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$"), USER_PASSWORD(
			"^[0-9A-Za-z]{4,32}$"), MD5_CHECKSUM("[a-fA-F0-9]{32}"), DELETE_FORBIDDEN_CHARACTERS(
			"[<>]"), USER_PHONE("[0-9]{6,15}$");

	private String regex;

	private Validator(String regex) {
		this.regex = regex;
	}

	public boolean validate(String string) {
		boolean res = false;

		if (string != null) {
			Pattern pattern = Pattern.compile(this.regex);
			Matcher matcher = pattern.matcher(string);
			res = matcher.matches();
		}

		return res;
	}

	public String deleteForbiddenCharacter(String string) {
		return string.replaceAll(this.regex, "#");
	}
}
