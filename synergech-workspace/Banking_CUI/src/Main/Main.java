package Main;

import java.sql.SQLException;
import java.util.Scanner;

import Response.CustomerResponse;
import Service.CustomerService;
import VO.CustomerVO;
import exception.AccountException;
import exception.DateException;
import exception.MobileException;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws AccountException, DateException, MobileException, SQLException,
			javax.security.auth.login.AccountException {
		boolean flag = true;
		while (flag) {
			System.out.println("Menu: \n1. Add Bank Account\n2. Fetch the Account Details\n3. Exit");
			System.out.print("Enter you Option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				addAccount();
				break;
			}
			case 2: {
				fetchAccount();
				break;
			}
			case 3: {
				System.out.println("Thank You !!!");
				flag = false;
			}
			default: {
				System.out.println("Enter the valid Option !!!");
			}
			}
		}
	}

	private static void addAccount() throws AccountException, DateException, MobileException, SQLException,
			javax.security.auth.login.AccountException {
		CustomerVO customer = new CustomerVO();
		CustomerService service = new CustomerService();
		CustomerResponse response = new CustomerResponse();
		System.out.println("Enter Account Number :");
		customer.setAccount_number(sc.nextLong());
		sc.nextLine();
		System.out.println("Enter the Name :");
		customer.setCustomer_name(sc.nextLine());
		System.out.println("Enter Mobile Number :");
		customer.setContact_no(sc.nextLong());
		System.out.println("Enter Aadhar Number :");
		customer.setAadhar_no(sc.nextLong());
		System.out.println("Enter the DOB (YYYY-MM-DD):");
		customer.setCustomer_dob(sc.next());
		System.out.println("Enter Amount :");
		customer.setAccount_balance(sc.nextDouble());
		response = service.addAccount(customer);
	}

	private static void fetchAccount()
			throws AccountException, SQLException, javax.security.auth.login.AccountException {
		CustomerService service = new CustomerService();
		CustomerResponse response = new CustomerResponse();
		System.out.println("Enter the Account Number :");
		long Acno = sc.nextLong();
		response = service.fetchAccount(Acno);
	}

}
