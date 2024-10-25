package com.Amount_Transaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amount_Transaction.BO.AccountBO;
import com.Amount_Transaction.Entity.AccountVO;
import com.Amount_Transaction.Exception.InValidAccountNumber;
import com.Amount_Transaction.Exception.InsufficientBalance;
import com.Amount_Transaction.Response.AccountResponseHandle;

@Service
public class AccountService {

	@Autowired
	private AccountResponseHandle accRes;

	@Autowired
	private AccountBO accBO;

	public AccountResponseHandle insertAccount(AccountVO vo) {
		AccountVO acc = accBO.insertAccount(vo);
		if (acc != null) {
			accRes.setSucessMessage("User Account Added");
			accRes.setAccVO(acc);
		} else {
			accRes.setFailureMessage("Error in Adding User Account");
		}
		return accRes;
	}

	public AccountResponseHandle transferAmount(long senderAccountNo, long receiverAccountNo, double amount)
			throws InsufficientBalance, InValidAccountNumber {
		AccountResponseHandle flag = accBO.transferAmount(senderAccountNo, receiverAccountNo, amount);
		if (flag.getSenderAcc() != null && flag.getReceiverAcc() != null) {
			accRes.setSucessMessage("Transaction done");
			accRes.setSenderAcc(flag.getSenderAcc());
			accRes.setReceiverAcc(flag.getReceiverAcc());
		} else {
			accRes.setFailureMessage("Operation failed");
		}
		return accRes;
	}

}
