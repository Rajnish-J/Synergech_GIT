package com.Amount_Transaction.BO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amount_Transaction.DAO.UserDAO;
import com.Amount_Transaction.Entity.UserVO;
import com.Amount_Transaction.Exception.InValidDateException;
import com.Amount_Transaction.Exception.InvalidEmailException;
import com.Amount_Transaction.Exception.NameException;
import com.Amount_Transaction.Exception.PasswordException;

@Component
public class UserBO {

	@Autowired
	private UserDAO userRepo;

	public UserVO insertUser(UserVO vo)
			throws InValidDateException, NameException, InvalidEmailException, PasswordException {
		validateUser(vo);
		userRepo.save(vo);
		return vo;
	}

	public void bulkInsert(List<UserVO> userList)
			throws InValidDateException, NameException, InvalidEmailException, PasswordException {
		System.out.println("Bo layer triggered");
//		for (UserVO user : userList) {
//			validateUser(user);
//		}
		userRepo.saveAll(userList);
	}

	private boolean vaildateDate(LocalDate dob) throws InValidDateException {
		if (dob == null) {
			throw new InValidDateException("Date of birth cannot be null.");
		}

		LocalDate today = LocalDate.now();

		if (!dob.isBefore(today)) {
			throw new InValidDateException("Date of birth must be a past date.");
		}
		return true;
	}

	private boolean vaildatePassword(String password) throws PasswordException {
		if (password.length() <= 8 && password.length() >= 12) {
			throw new PasswordException("Password must be greater than 8 characters and less than 12 characters.");
		}

		boolean hasUppercase = false;
		boolean hasLowercase = false;
		boolean hasSpecialChar = false;

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUppercase = true;
			} else if (Character.isLowerCase(c)) {
				hasLowercase = true;
			} else if (!Character.isLetterOrDigit(c)) {
				hasSpecialChar = true;
			}
		}
		if (!hasUppercase) {
			throw new PasswordException("InValid Password : Password must contain at least one uppercase letter.");
		}
		if (!hasLowercase) {
			throw new PasswordException("InValid Password : Password must contain at least one lowercase letter.");
		}
		if (!hasSpecialChar) {
			throw new PasswordException("InValid Password : Password must contain at least one special character.");
		}

		return true;
	}

	private boolean vaildateEmail(String email) throws InvalidEmailException {
		if (!email.contains("@gmail.com")) {
			throw new InvalidEmailException("Enter valid Email address");
		}

		return true;
	}

	private boolean validateName(String name) throws NameException {
		if (name == null) {
			throw new NameException("ERROR : Invalid Name :" + name);
		}

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
				throw new NameException(
						"ERROR: Invalid Name: " + name + ". Name must contain only letters and spaces.");
			}
		}

		return true;
	}

	private boolean validateUser(UserVO vo)
			throws InValidDateException, NameException, InvalidEmailException, PasswordException {
		return (vaildateDate(vo.getDob()) && validateName(vo.getUserName()) && vaildateEmail(vo.getUserEmail())
				&& vaildatePassword(vo.getUserPassword()));
	}

}
