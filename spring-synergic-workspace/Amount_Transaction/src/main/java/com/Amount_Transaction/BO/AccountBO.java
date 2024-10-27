package com.Amount_Transaction.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amount_Transaction.DAO.AccountDAO;
import com.Amount_Transaction.Entity.AccountVO;
import com.Amount_Transaction.Exception.InValidAccountNumber;
import com.Amount_Transaction.Exception.InsufficientBalance;
import com.Amount_Transaction.Response.AccountResponseHandle;

@Component
public class AccountBO {

	@Autowired
	private AccountDAO accRepo;

	@Autowired
	private AccountResponseHandle accRes;

	public AccountVO insertAccount(AccountVO vo) {
		accRepo.save(vo);
		return vo;
	}

	public AccountResponseHandle transferAmount(String senderAccountNo, String receiverAccountNo, double amount)
			throws InsufficientBalance, InValidAccountNumber {

		AccountVO senderAccount = validAccount(senderAccountNo);
		double senderbalance = senderAccount.getBalance();
		validbalance(senderbalance, amount);
		AccountVO receiverAccount = validAccount(receiverAccountNo);

		// sender balance reduced :
		double senderBalance = senderAccount.getBalance() - amount;
		senderAccount.setBalance(senderBalance);
		accRepo.save(senderAccount);
		accRes.setSenderAcc(senderAccount);

		double recevierbalance = receiverAccount.getBalance() + amount;
		receiverAccount.setBalance(recevierbalance);
		accRepo.save(receiverAccount);
		accRes.setReceiverAcc(receiverAccount);

		return accRes;

	}

	public List<AccountVO> minAccs() {
		return (accRepo.findAccountWithMinBalance());

	}

	public List<AccountVO> maxAccs() {
		return (accRepo.findAccountWithMaxBalance());

	}

	// Validations
	private AccountVO validAccount(String senderAccountNo) throws InValidAccountNumber {
		AccountVO account = accRepo.findByAccountNumber(senderAccountNo);
		if (account == null) {
			throw new InValidAccountNumber("Account not exit in the DataBase");
		}
		return account;
	}

	// Validation

	private boolean validbalance(double balance, double amount) throws InsufficientBalance {

		boolean flag = false;
		if (balance < amount) {
			throw new InsufficientBalance("Insufficient Balance");
		} else {
			flag = true;
		}
		return flag;
	}

}
