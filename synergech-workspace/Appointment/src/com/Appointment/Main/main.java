package com.Appointment.Main;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.Appointment.VO.PatientVO;
import com.Appointment.customExceptions.AccountcreationException;
import com.Appointment.customExceptions.EmailException;
import com.Appointment.customExceptions.PasswordException;
import com.Appointment.customExceptions.PatientNotFoundException;
import com.Appointment.customExceptions.UpdateException;
import com.Appointment.customExceptions.phoneNumberException;
import com.Appointment.service.patientService;

public class main {
	static Scanner sc = new Scanner(System.in);
	static Logger Log = Logger.getLogger(main.class);

	public static void main(String[] args) throws SQLException, PatientNotFoundException, phoneNumberException,
			EmailException, PasswordException, AccountcreationException, UpdateException {

		PropertyConfigurator.configure(
				"C:\\Users\\Lenovo\\OneDrive\\Desktop\\GIT\\Synergech_GIT\\synergech-workspace\\Appointment\\src\\com\\Appointment\\properities\\log4j.properities");
		Log.info(" Application Started Started..");

		boolean repeat_menu = true;

		while (repeat_menu) {
			System.out.println("Menu: ");
			System.out.println(
					"1. Save Paitent\n2. Fetch by ID\n3. Fetch All patient\n4. Update patient details\n5. Exit");
			System.out.print("Enter the option: ");
			int option = sc.nextInt();

			switch (option) {
			case 1: {
				savePatient();
				break;
			}
			case 2: {
				fetchbyID();
				break;
			}
			case 3: {
				fetchAll();
				break;
			}
			case 4: {
				updatePatientDetails();
				break;
			}
			case 5: {
				repeat_menu = false;
				System.out.println("Thank you for using the application");
				break;
			}

			}
		}

	}

	public static void savePatient() throws SQLException, PatientNotFoundException, phoneNumberException,
			EmailException, PasswordException, AccountcreationException {
		PatientVO pOBJ = new PatientVO();
		patientService pser = new patientService();

		System.out.print("Enter the patient ID: ");
		pOBJ.setPatientId(sc.nextInt());

		System.out.print("Enter the patient First Name: ");
		pOBJ.setfName(sc.next());

		System.out.print("Enter the patient Last Name: ");
		pOBJ.setlName(sc.next());

		System.out.print("Enter the patient Date of birth in the format (YYYY-MM-DD): ");
		pOBJ.setDob(sc.next());

		System.out.print("Enter the patient mobile number: ");
		pOBJ.setP_phone(sc.next());

		System.out.print("Enter the patient Email: ");
		pOBJ.setP_email(sc.next());

		System.out.print("Enter the patient Password: ");
		pOBJ.setP_password(sc.next());

		System.out.println(pser.savePatientDetails(pOBJ));
	}

	public static void fetchbyID() throws SQLException {
		patientService pser = new patientService();
		System.out.print("Enter the patient ID to retrieve the patient details: ");
		System.out.println(pser.fetchByID(sc.nextInt()));
	}

	public static void fetchAll() throws SQLException {
		patientService pser = new patientService();
		System.out.println("Details of All patients: ");
		for (PatientVO obj : pser.fetchAll()) {
			System.out.println(obj);
		}
	}

	public static void updatePatientDetails() throws SQLException, UpdateException {
		patientService pser = new patientService();
		pser.updatePatientDetails();
	}

}
