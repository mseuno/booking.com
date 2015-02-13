package com.epam.lab.service;

import com.epam.lab.model.Admin;
import com.epam.lab.model.Manager;
import com.epam.lab.model.User;
import com.epam.lab.utils.MD5Encrypter;
import com.epam.lab.utils.Validator;

public class LoginService {

	// Static "salt" for hash-function
	private final String salt = "OBAFGKM";

	private UserService userService = new UserService();
	private ManagerService managerService = new ManagerService();
	private AdminService adminService = new AdminService();

	public User loginUser(String email, String password) {
		User user = null;
		if (checkEmailAndPassword(email, password)) {
			user = userService.selectUserByEmailAndPassword(email,
					generateHash(email, password));
		}
		return user;
	}

	public Manager loginManager(String email, String password) {
		Manager manager = null;

		if (checkEmailAndPassword(email, password)) {
			manager = managerService.selectManagerByEmailAndPassword(email,
					generateHash(email, password));
		}
		return manager;
	}

	public Admin loginAdmin(String email, String password) {
		Admin admin = null;

		if (checkEmailAndPassword(email, password)) {
			admin = adminService.selectAdminByEmailAndPassword(email,
					generateHash(email, password));
		}
		return admin;
	}

	private boolean checkEmailAndPassword(String email, String password) {
		boolean EmailIsCorrect = Validator.USER_EMAIL.validate(email);
		boolean PasswordIsCorrect = Validator.USER_PASSWORD.validate(password);

		return EmailIsCorrect && PasswordIsCorrect;
	}

	public String generateHash(String email, String password) {
		return MD5Encrypter.encrypt(password + email + salt);
	}
}
