package com.projectDemo1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.projectDemo1.Entity.appointmentsVO;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.Response.ResponseHandle;
import com.projectDemo1.Service.patientService;
import com.projectDemo1.customExceptions.patientException;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectDemo1Application {

	@Autowired
	public patientService pService;

	@Autowired
	private ResponseHandle response;

	public static void main(String[] args) throws patientException {
		ApplicationContext ctx = SpringApplication.run(ProjectDemo1Application.class, args);
		Scanner sc = new Scanner(System.in);

		ProjectDemo1Application ref = ctx.getBean(ProjectDemo1Application.class);

		boolean repeat = true;
		do {
			System.out.println(
					"1. Save Patient\n2. FindByID\n3. FetchAllPatients\n4. Update Details\n5. Associate\n6. Exit");
			System.out.print("Enter the option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				ref.insert();
				break;
			}
			case 2: {
				System.out.print("Enter the patient ID: ");
				long id = sc.nextLong();
				System.out.println(ref.fetchByID(id));
				break;
			}
			case 3: {
				ref.fetchAll();
				break;
			}
			case 4: {
				System.out.print("Enter the patient ID: ");
				int id = sc.nextInt();
				ref.update(id);
				break;
			}
			case 5: {
				ref.AssociatePatientwithAppointment();
			}
			case 6: {
				repeat = false;
				System.out.println("Thank you for Using the application");
				break;
			}
			}
		} while (repeat);

	}

//insert method
	public void insert() throws patientException {
		Scanner sc = new Scanner(System.in);
		patientVO patient = new patientVO();

		System.out.print("Enter the First Name: ");
		patient.setFirstName(sc.next());

		System.out.print("Enter the Last Name: ");
		patient.setLastName(sc.next());

		System.out.print("Enter the phone number: ");
		patient.setPatientPhone(sc.next());

		System.out.print("Enter the Date of birth in the format (YYYY-MM-DD): ");
		String date = sc.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(date, format);
		patient.setDob(dob);

		System.out.print("Enter the Email: ");
		patient.setPatientEmail(sc.next());

		System.out.print("Enter the Password: ");
		patient.setPatientPassword(sc.next());

		response = pService.insertPatientDetails(patient);

		if (response.getId() > 0) {
			System.out.println("Your Generated Patient ID is: " + response.getId());
		} else {
			System.err.println("Failed");
		}
	}

	// fetch by ID:
	public patientVO fetchByID(long id) throws patientException {
		response = pService.fetchById(id);
		return response.getPatient();
	}

	// fetch all method:
	public void fetchAll() {
		response = pService.fetchAll();
		List<patientVO> patientlist = response.getListpatient();
		for (patientVO obj : patientlist) {
			System.out.println(obj);
		}
	}

	// update method:
	public void update(long id) throws patientException {
		response = pService.updatePatientDetails(id);
		if (response.getSucessmessage() != null) {
			System.out.println(response.getSucessmessage());
		}
	}

	// associate method:
	public void AssociatePatientwithAppointment() {

		Scanner sc = new Scanner(System.in);
		patientVO patient = new patientVO();

		System.out.print("Enter the First Name: ");
		patient.setFirstName(sc.next());

		System.out.print("Enter the Last Name: ");
		patient.setLastName(sc.next());

		System.out.print("Enter the phone number: ");
		patient.setPatientPhone(sc.next());

		System.out.print("Enter the Date of birth in the format (YYYY-MM-DD): ");
		String date = sc.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(date, format);
		patient.setDob(dob);

		System.out.print("Enter the Email: ");
		patient.setPatientEmail(sc.next());

		System.out.print("Enter the Password: ");
		patient.setPatientPassword(sc.next());

		System.out.println("Enter Number of Appointments Details :");
		int n = sc.nextInt();

		List<appointmentsVO> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			appointmentsVO appt = new appointmentsVO();

			System.out.print("Enter the Date of Appointment in the format (YYYY-MM-DD): ");
			String appt_date = sc.next();
			DateTimeFormatter format_appt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate appnt_date = LocalDate.parse(appt_date, format_appt);
			appt.setAppointmentDate(appnt_date);

			sc.nextLine();
			System.out.println("Enter the reason: ");
			appt.setReason(sc.nextLine());

			System.out.println("Enter the doctor ID: ");
			appt.setDoctorId(sc.nextLong());

			appt.setPatient(patient);
			list.add(appt);
		}

		patient.setAppointments(list);
		response = pService.associate(patient);

		long id = response.getId();

		if (id > 0) {
			System.out.println(response.getSucessmessage());
		} else {
			System.out.println(response.getFailuremessage());
		}

	}

}