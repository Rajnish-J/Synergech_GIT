CREATE DATABASE project_demo;

-- 1. Hospitals table
use project_demo;
CREATE TABLE Hospital (
    hospital_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hospital_name VARCHAR(100) NOT NULL,
    hospital_phone VARCHAR(15) NOT NULL UNIQUE,
    hospital_email VARCHAR(100) UNIQUE NOT NULL,
    city_id int,
    state_id int,
    country_id int,
    createdAt date not null,
    updatedAt date not null,
    FOREIGN KEY (city_id) REFERENCES City(city_id),
    FOREIGN KEY (state_id) REFERENCES State(state_id),
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

-- 2. specialization table
use project_demo;
CREATE TABLE specialization (
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    SpecialtyName VARCHAR(100) NOT NULL UNIQUE
);

-- 3. Create the AppointmentStatus table
use project_demo;
CREATE TABLE AppointmentStatus (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    StatusName VARCHAR(50) NOT NULL UNIQUE
);

-- 4. city table
use project_demo; 
CREATE TABLE city(
	city_id INT PRIMARY KEY AUTO_INCREMENT,
    city varchar(50) NOT NULL UNIQUE
);

-- 5. state table
use project_demo; 
CREATE TABLE state(
	state_id INT PRIMARY KEY AUTO_INCREMENT,
    State varchar(50) NOT NULL UNIQUE
);

-- 6. country table
use project_demo; 
CREATE TABLE country(
	country_id INT PRIMARY KEY AUTO_INCREMENT,
    Country varchar(50) NOT NULL UNIQUE
);

-- 7. Doctor table
use project_demo;
CREATE TABLE Doctor (
    doctor_id bigint AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    doc_phone VARCHAR(15) NOT NULL UNIQUE,
    doc_email VARCHAR(100) NOT NULL UNIQUE,
    doc_password VARCHAR(12) NOT NULL UNIQUE,  
    hospital_id bigint,
    specialization_id INT,
    createdAt date not null,
    updatedAt date not null,
    FOREIGN KEY (hospital_id) REFERENCES Hospital(hospital_id),
    FOREIGN KEY (specialization_id) REFERENCES specialization(specialization_id)
);

-- 8. Patients Table
use project_demo;
CREATE TABLE Patients (
    patient_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    patient_phone VARCHAR(15) NOT NULL UNIQUE,
    patient_email VARCHAR(100) NOT NULL UNIQUE,
    patient_password VARCHAR(12) NOT NULL UNIQUE,
    createdAt date not null,
    updatedAt date not null
);

-- 9. Appointments table
use project_demo;
CREATE TABLE Appointments (
    appointment_id bigint AUTO_INCREMENT PRIMARY KEY,
    doctor_id bigint,
    patient_id bigint,
    appointment_date DATETIME not null,
    reason VARCHAR(255),
    status_id INT,
    createdAt date not null,
    updatedAt date not null,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (status_id) REFERENCES AppointmentStatus(status_id)
);