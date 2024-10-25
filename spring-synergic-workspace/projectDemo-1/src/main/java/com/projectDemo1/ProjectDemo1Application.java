package com.projectDemo1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.projectDemo1.Entity.appointmentsVO;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.Response.ResponseHandle;
import com.projectDemo1.Service.patientService;
import com.projectDemo1.customExceptions.AppointmentBookingDateException;
import com.projectDemo1.customExceptions.AppointmentException;
import com.projectDemo1.customExceptions.DateOfBirthException;
import com.projectDemo1.customExceptions.EmailException;
import com.projectDemo1.customExceptions.IdException;
import com.projectDemo1.customExceptions.PasswordException;
import com.projectDemo1.customExceptions.PhoneNumberException;
import com.projectDemo1.customExceptions.patientException;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectDemo1Application {

	@Autowired
	public patientService pService;

	@Autowired
	private ResponseHandle response;

	static Logger log = Logger.getLogger(ProjectDemo1Application.class);

	public static void main(String[] args) throws patientException {
		ApplicationContext ctx = SpringApplication.run(ProjectDemo1Application.class, args);
		Scanner sc = new Scanner(System.in);

		ProjectDemo1Application ref = ctx.getBean(ProjectDemo1Application.class);

		PropertyConfigurator.configure(
				"C:\\Users\\Lenovo\\OneDrive\\Desktop\\GIT\\Synergech_GIT\\spring-synergic-workspace\\projectDemo-1\\src\\main\\java\\log4j\\log4j.properities");
		log.info(" Application Started Started..");

		log.info(" Application Started Started...");
		boolean repeat = true;
		do {
			System.out.println("1. Save Patient\n2. FindByID\n3. FetchAllPatients\n4. Update Details\n5. Associate\n6. "
					+ "Fetch patient by phone number\n7. fetch appointments by the date\n8. Fetch appointments having more than number\n9. "
					+ "Find first and last name by patient ID\n10. Fetch all the patient details among the two date\n11. Get the patients in "
					+ "Ascending order\n12. exit");
			System.out.print("Enter the option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				log.info("Patient chooses create account option...");
				ref.insert();
				break;
			}
			case 2: {
				log.info("patient chooses fetch Details by their ID...");
				System.out.print("Enter the patient ID: ");
				long id = sc.nextLong();
				System.out.println(ref.fetchByID(id));
				break;
			}
			case 3: {
				log.info("patient chooses fetch all the details option...");
				ref.fetchAll();
				break;
			}
			case 4: {
				log.info("patient chooses Update their information by their ID...");
				System.out.print("Enter the patient ID: ");
				int id = sc.nextInt();
				ref.update(id);
				break;
			}
			case 5: {
				log.info("patient chooses to create account with booking appointments...");
				ref.AssociatePatientwithAppointment();
				break;
			}
			case 6: {
				log.info("patient chooses fetching their details by their phone number...");
				System.out.print("Enter the patient phone number to fetch patient Details: ");
				String ph = sc.next();
				ref.fetchbyPhone(ph);
				break;
			}
			case 7: {
				log.info("patient chooses to fetch the appointment details by the day...");
				ref.fetchapptday();
				break;
			}
			case 8: {
				System.out.println("Enter the number that fetches patient having more appoinments than the number: ");
				long n = sc.nextLong();
				ref.fetchAppointmentbynumber(n);
				break;
			}
			case 9: {
				log.info("patient chooses Find their First and Last names in the records...");
				System.out.println("Enter the patient ID: ");
				long n = sc.nextLong();
				ref.findName(n);
				break;
			}
			case 10: {
				log.info("patient chooses ferching the patient details with the two dates...");
				System.out.print("Enter the Start Date in the format (YYYY-MM-DD): ");
				String start_date = sc.next();
				System.out.print("Enter the End Date in the format (YYYY-MM-DD): ");
				String end_date = sc.next();
				DateTimeFormatter format_appt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate started_date = LocalDate.parse(start_date, format_appt);
				LocalDate ended_date = LocalDate.parse(end_date, format_appt);

				ref.betweenTwoDOBpat(started_date, ended_date);
				break;

			}
			case 11: {
				log.info("patient chooses fetching all the patient details in ascending order...");
				ref.ascending();
				break;

			}
			case 12: {
				log.info("patient chooses to EXIT the application...");
				repeat = false;
				System.out.println("Thank you for Using the application");
				break;
			}
			default: {
				System.out.println("Enter the correct option");
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

		try {
			response = pService.insertPatientDetails(patient);
		} catch (patientException e) {
			log.error("Patient Details details records not in the format", e);
			System.err.println(e.getMessage());
		} catch (PhoneNumberException e) {
			log.error("Phone number format is wrong", e);
			System.err.println(e.getMessage());
		} catch (EmailException e) {
			log.error("email format is not valid", e);
			System.err.println(e.getMessage());
		} catch (PasswordException e) {
			log.error("password format is not valid", e);
			System.err.println(e.getMessage());
		} catch (DateOfBirthException e) {
			log.error("Date of Birth format is not in the pattern", e);
			System.err.println(e.getMessage());
		}

		if (response.getPatient().getPatientId() > 0) {
			System.out.println("Your Generated Patient ID is: " + response.getPatient().getPatientId());

		} else {
			System.out.println("Failed");
		}
	}

	// fetch by ID:
	public patientVO fetchByID(long id) throws patientException {
		try {
			response = pService.fetchById(id);
		} catch (IdException e) {
			log.error("ID not found in the DateBase", e);
			System.err.println(e.getMessage());
			System.out.println(response.getFailuremessage());//
		}
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
		try {
			response = pService.updatePatientDetails(id);
		} catch (IdException e) {
			log.error("ID not found in the DataBase", e);
			System.err.println(e.getMessage());
		}
		if (response.getSucessmessage() != null) {
			System.out.println(response.getSucessmessage());
		}
	}

	// associate method:
	public void AssociatePatientwithAppointment() throws patientException {

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
		try {
			response = pService.associate(patient);
		} catch (patientException e) {
			log.error("Patient Details details records not in the format", e);
			System.err.println(e.getMessage());
		} catch (PhoneNumberException e) {
			log.error("Phone number format is wrong", e);
			System.err.println(e.getMessage());
		} catch (EmailException e) {
			log.error("email format is not valid", e);
			System.err.println(e.getMessage());
		} catch (PasswordException e) {
			log.error("password format is not valid", e);
			System.err.println(e.getMessage());
		} catch (AppointmentException e) {
			log.error("book atleast one appointments", e);
			System.err.println(e.getMessage());
		} catch (AppointmentBookingDateException e) {
			log.error("Appointment booking date could not be in the Past", e);
			System.err.println(e.getMessage());
		} catch (DateOfBirthException e) {
			log.error("date of birth could not be in the Future", e);
			System.err.println(e.getMessage());
		}

		long id = response.getId();

		if (id > 0) {
			System.out.println(response.getSucessmessage());
		} else {
			System.out.println(response.getFailuremessage());
		}

	}

	// fetch by phone number
	public void fetchbyPhone(String ph) {
		try {
			response = pService.findbyphone(ph);
			System.out.println(response.getPatient());
		} catch (PhoneNumberException e) {
			log.error("phone number exception caught", e);
			System.err.println(e.getMessage());
		}

	}

	// fetch today appointments
	public void fetchapptday() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the date in the format (YYYY-MM-DD): ");
		String date = sc.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate day = LocalDate.parse(date, format);

		response = pService.findapptDay(day);
		System.out.println(response.getListpatient());
	}

	// fetch by more appointments
	public void fetchAppointmentbynumber(long n) {
		response = pService.findAppointmentsByNumber(n);
		System.out.println("The users have more than appointments by given: ");
		System.out.println(response.getListpatient());
	}

	// fetch first name and last name:
	public void findName(long id) {
		try {
			response = pService.findName(id);
			System.out.println("First name: " + response.getPro().getFirstName() + " Second name: "
					+ response.getPro().getLastName());
		} catch (IdException e) {
			log.error("Id Exception", e);
			System.err.println(e.getMessage());
		}

	}

	// Appointment by between two days:
	public void betweenTwoDOBpat(LocalDate sd, LocalDate ld) {
		response = pService.betweenTwoDOBpat(sd, ld);
		for (patientVO obj : response.getListpatient()) {
			System.out.println(obj);
		}
	}

	// ascending order:
	public void ascending() {
		response = pService.acending();
		for (patientVO obj : response.getListpatient()) {
			System.out.println(obj);
		}
	}

}