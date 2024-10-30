package com.Amount_Transaction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amount_Transaction.BO.UserBO;
import com.Amount_Transaction.Entity.UserVO;
import com.Amount_Transaction.Exception.InValidDateException;
import com.Amount_Transaction.Exception.InvalidEmailException;
import com.Amount_Transaction.Exception.NameException;
import com.Amount_Transaction.Exception.PasswordException;
import com.Amount_Transaction.Response.UserResponseHandle;

@Service
public class UserService {

	@Autowired
	private UserBO userBO;

	@Autowired
	private UserResponseHandle userRes;

	public UserResponseHandle insertUser(UserVO vo)
			throws InValidDateException, NameException, InvalidEmailException, PasswordException {
		UserVO user = userBO.insertUser(vo);
		if (user != null) {
			userRes.setSucessMessage("User Account Added");
			userRes.setUserVO(user);
		} else {
			userRes.setFailureMessage("Error in Adding User Account");
		}
		return userRes;
	}

	public UserResponseHandle bulkInsert(List<UserVO> userList)
			throws InValidDateException, NameException, InvalidEmailException, PasswordException {
		String str = userBO.bulkInsert(userList);
		if (str != null) {
			userRes.setSucessMessage("All the records added successfully");
			userRes.setUserList(userList);
		} else {
			userRes.setFailureMessage("Error in adding all the details");
		}
		return userRes;

	}

}
