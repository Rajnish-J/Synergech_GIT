package com.Amount_Transaction.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amount_Transaction.DAO.UserDAO;
import com.Amount_Transaction.Entity.UserVO;

@Component
public class UserBO {

	@Autowired
	private UserDAO userRepo;

	public UserVO insertUser(UserVO vo) {
		userRepo.save(vo);
		return vo;
	}

}
