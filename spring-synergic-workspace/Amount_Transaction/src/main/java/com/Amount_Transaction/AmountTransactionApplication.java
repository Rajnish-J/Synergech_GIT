package com.Amount_Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Amount_Transaction.Entity.AccountVO;
import com.Amount_Transaction.Entity.UserVO;
import com.Amount_Transaction.Exception.InValidAccountNumber;
import com.Amount_Transaction.Exception.InValidDateException;
import com.Amount_Transaction.Exception.InsufficientBalance;
import com.Amount_Transaction.Exception.InvalidEmailException;
import com.Amount_Transaction.Exception.NameException;
import com.Amount_Transaction.Exception.PasswordException;
import com.Amount_Transaction.Response.AccountResponseHandle;
import com.Amount_Transaction.Response.UserResponseHandle;
import com.Amount_Transaction.Service.AccountService;
import com.Amount_Transaction.Service.UserService;

@SpringBootApplication
public class AmountTransactionApplication {

	@Autowired
	private UserService userSer;

	@Autowired
	private AccountService accSer;

	@Autowired
	private UserResponseHandle uRes;

	@Autowired
	private AccountResponseHandle aRes;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AmountTransactionApplication.class, args);

		AmountTransactionApplication app = ctx.getBean(AmountTransactionApplication.class);

		boolean flag = true;
		Scanner scanner = new Scanner(System.in);

		while (flag) {

			System.out.println("MENU");
			System.out.println(
					"1. insert User\n2. insert Account\n3. Amount Transfer\n4. Bulk Insert User\n5. Minimum account balance users"
							+ "\n6. Maximum account balance users\n7.exit");
			System.out.println("Enter Your Option :");

			int option = scanner.nextInt();

			switch (option) {

			case 1: {
				app.insertUser();
				break;
			}
			case 2: {
				app.insertAccount();
				break;
			}
			case 3: {
				app.amountTransfer();
				break;
			}
			case 4: {
				app.bulkInsert();
				break;
			}
			case 5: {
				app.minAccs();
				break;
			}
			case 6: {
				app.maxAccs();
				break;
			}
			case 7: {
				flag = false;
				break;
			}
			default: {
				System.out.println("Enter the Valid Option");
			}
			}

		}

	}

	// Amount Transfer

	private void amountTransfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sender Account Number :");
		String senderAccountNo = sc.next();

		System.out.println("Enter Receiver Account Number :");
		String receiverAccountNo = sc.next();

		System.out.println("Enter the Account to Transfer :");
		double amount = sc.nextDouble();

		try {
			accSer.transferAmount(senderAccountNo, receiverAccountNo, amount);
		} catch (InsufficientBalance e) {
			System.out.println(e.getMessage());
		} catch (InValidAccountNumber e) {
			System.out.println(e.getMessage());
		}
	}

	// Insert Account

	private void insertAccount() {
		Scanner sc = new Scanner(System.in);
		AccountVO accountObj = new AccountVO();

		System.out.println("Enter the Account Number :");
		accountObj.setAccountNumber(sc.next());

		System.out.println("Enter the Branch Code :");
		accountObj.setBranchCode(sc.next());

		System.out.println("Enter the Balance :");
		accountObj.setBalance(sc.nextDouble());

		System.out.println("Enter the user Id");
		UserVO userObj = new UserVO();
		userObj.setId(sc.nextLong());
		accountObj.setUser(userObj);

		accSer.insertAccount(accountObj);

	}

	// Insert User

	private void insertUser() {
		Scanner sc = new Scanner(System.in);

		UserVO userobj = new UserVO();

		System.out.println("Enter User Name :");
		userobj.setUserName(sc.nextLine());

		System.out.print("Enter your Date of Birth (yyyy-MM-dd): ");
		String input = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(input, formatter);
		userobj.setDob(date);

		System.out.println("Enter the email:");
		userobj.setUserEmail(sc.next());

		System.out.println("Enter the Password :");
		userobj.setUserPassword(sc.next());

		try {
			userSer.insertUser(userobj);
		} catch (InValidDateException e) {
			e.getMessage();
		} catch (NameException e) {
			e.getMessage();
		} catch (InvalidEmailException e) {
			e.getMessage();
		} catch (PasswordException e) {
			e.getMessage();
		}

	}

	private void bulkInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to add Number of user accounts: ");
		long num = sc.nextLong();

		List<UserVO> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			UserVO user = new UserVO();
			user.setUserName("user");
			user.setUserEmail("user" + i + "gmail.com");
			user.setUserPassword("Pass@word" + i);
			user.setDob(LocalDate.of(1989, 1, 1));

			list.add(user);
		}

		try {
			uRes = userSer.bulkInsert(list);
		} catch (InValidDateException e) {
			e.getMessage();
		} catch (NameException e) {
			e.getMessage();
		} catch (InvalidEmailException e) {
			e.getMessage();
		} catch (PasswordException e) {
			e.getMessage();
		}

		if (uRes.getSucessMessage() != null) {
			System.out.println(uRes.getSucessMessage());
			for (UserVO obj : uRes.getUserList()) {
				System.out.println(obj.getId());
			}
		} else {
			System.out.println(uRes.getFailureMessage());
		}
	}

	public void minAccs() {
		aRes = accSer.minAccs();

		if (aRes.getSucessMessage() != null) {
			System.out.println(aRes.getSucessMessage());
			for (AccountVO obj : aRes.getAccList()) {
				System.out.println(obj);
			}
		} else {
			System.out.println(aRes.getFailureMessage());
		}
	}

	public void maxAccs() {
		aRes = accSer.maxAccs();

		if (aRes.getSucessMessage() != null) {
			System.out.println(aRes.getSucessMessage());
			for (AccountVO obj : aRes.getAccList()) {
				System.out.println(obj);
			}
		} else {
			System.out.println(aRes.getFailureMessage());
		}
	}

}
