package com.Amount_Transaction.Response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Amount_Transaction.Entity.AccountVO;
import com.Amount_Transaction.Entity.UserVO;

@Component
public class UserResponseHandle {

	private String sucessMessage;
	private String failureMessage;
	private long id;
	private UserVO userVO;
	private List<UserVO> userList;
	private List<AccountVO> accList;

	public String getSucessMessage() {
		return sucessMessage;
	}

	public void setSucessMessage(String sucessMessage) {
		this.sucessMessage = sucessMessage;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public List<AccountVO> getList() {
		return accList;
	}

	public void setList(List<AccountVO> list) {
		this.accList = list;
	}

	public List<UserVO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}

}
