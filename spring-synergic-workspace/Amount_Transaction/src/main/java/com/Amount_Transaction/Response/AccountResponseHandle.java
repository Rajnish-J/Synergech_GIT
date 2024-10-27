package com.Amount_Transaction.Response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Amount_Transaction.Entity.AccountVO;
import com.Amount_Transaction.Entity.UserVO;

@Component
public class AccountResponseHandle {

	private String sucessMessage;
	private String failureMessage;
	private long id;
	private UserVO userVo;
	private AccountVO senderAcc;
	private AccountVO receiverAcc;
	private AccountVO accVO;
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

	public UserVO getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVO userVo) {
		this.userVo = userVo;
	}

	public AccountVO getSenderAcc() {
		return senderAcc;
	}

	public void setSenderAcc(AccountVO senderAcc) {
		this.senderAcc = senderAcc;
	}

	public AccountVO getReceiverAcc() {
		return receiverAcc;
	}

	public void setReceiverAcc(AccountVO receiverAcc) {
		this.receiverAcc = receiverAcc;
	}

	public AccountVO getAccVO() {
		return accVO;
	}

	public void setAccVO(AccountVO accVO) {
		this.accVO = accVO;
	}

	public List<AccountVO> getAccList() {
		return accList;
	}

	public void setAccList(List<AccountVO> accList) {
		this.accList = accList;
	}

}
