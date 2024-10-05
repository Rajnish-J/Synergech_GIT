package com.EntityBeanSeminar.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

/*
 * @Entity => marked as the JPA entity
 * @EntityListeners(AuditingEntityListener.class) => it listens the class when 
 * the createdAt or LastModified triggered 
 * this audits the time stamp and reports to JPA
 * note: we have to enable @EnableJpaAuditing annotation in the application or main file.
 */
@Entity
@Table(name = "patients")
/*
 * @Table => this annotation is used to map the java class as an table in db
 * 
 * attribute : name = change or validate the name in the db
 */
@EntityListeners(AuditingEntityListener.class)
public class PatientVO {

	@Id
	/*
	 * @Id => this annotation is used to mark the java state/field in to an primary
	 * key.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * @GeneratedValue => used to mark the auto increment constraint to java field
	 * 
	 * attribute:
	 * 
	 * AUTO => JPA provider selects the best strategy based on the database
	 * 
	 * IDENTITY => The database auto-generates a unique values upon insertion using
	 * an auto-increment constraint
	 * 
	 * SEQUENCE => use a database sequence to generate unique keys before insertion
	 * 
	 * TABLE => uses a separate table to manage key generation
	 */
	@Column(name = "patient_id")
	private Long patientId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Column(name = "patient_phone", nullable = false, unique = true)
	private String patientPhone;

	@Column(name = "patient_email", nullable = false, unique = true)
	/*
	 * @Column => used to mark the java field as an column in the database
	 * 
	 * attributes => used to mark the constraints for the particular column through
	 * java field name
	 * 
	 * change the name or validate the name in the database
	 * 
	 * nullable = mark is the field to NOT NULL or NULL
	 * 
	 * true => NULL
	 * 
	 * false => NOT NULL
	 * 
	 * unique = this helps to make the field is unique or not unique true => unique
	 * constraint false => not unique constraint
	 */
	private String patientEmail;

	@Column(name = "patient_password", nullable = false)
	private String patientPassword;

	@CreatedDate
	@Column(name = "created_at", nullable = false)
	/*
	 * @CreatedDate => automatically stores the time stamp when the record inserted
	 */
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	/*
	 * @LastModifiedDate => automatically stores the time stamp when the record
	 * updated.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	/*
	 * @Temporal => used to save the time in the format of time stamp
	 */
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	/*
	 * used to map the two tables and act as foreign key:
	 * 
	 * mappedBy => maps the corresponding relation to the respective field in the
	 * another entity
	 * 
	 * @OneToMany => one patient have many appointments
	 * 
	 * @OneToOne => in the doctor and hospital tables having doctor id in the
	 * hospital
	 * 
	 * @ManyToOne => many appointments may have to doctor
	 * 
	 * FetchType: LAZY => performs the fetching in one table EAGER => performs JOINS
	 * operation and fetch from two table
	 * 
	 * CascadeType.ALL => It will affect the changes in the depending tables also
	 * respective to the query logic
	 */
	@OrderBy // default ordering by patient ID
	/*
	 * @OrderBy=> order the List in the SQL itself whenever we fetch, it gives in
	 * the ascending or descending order with respect to primary key
	 * 
	 * @OrderBy("firstName ASC")
	 */
	private List<AppointmentVO> appointments;

	@Version
	/*
	 * The @Version annotation is used to make an filed as version field, which is
	 * used to maintain a version number or time stamp for the entity.
	 */
	@Column(name = "version")
	private Long version;

	@Transient
	/*
	 * @Transient => temporary filed in the entity and does not add any columns in
	 * the database in the runtime to make sum calculations we use Transient
	 * annotation
	 */
	private String temporaryField;

	@Lob
	/*
	 * @Lob is used to mark the column as an Large objects similar to SQL data type
	 * CLOB or BLOB
	 */
	@Column(name = "medical_history")
	private String medicalHistory;

	// ---------------------------------------------------------------------------------------------------------
	// //
	// Getters and Setters
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<AppointmentVO> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentVO> appointments) {
		this.appointments = appointments;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getTemporaryField() {
		return temporaryField;
	}

	public void setTemporaryField(String temporaryField) {
		this.temporaryField = temporaryField;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", patientPhone=" + patientPhone + ", patientEmail=" + patientEmail + ", patientPassword="
				+ patientPassword + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", version=" + version
				+ "]";
	}
}
