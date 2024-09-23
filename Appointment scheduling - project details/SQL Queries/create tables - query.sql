create database appointment;

-- 1. Hospitals table
use appointment;
CREATE TABLE Hospital (
    HospitalID INT AUTO_INCREMENT PRIMARY KEY,
    HospitalName VARCHAR(100) NOT NULL,
    HospitalAddress VARCHAR(255) NOT NULL,
    H_Phone VARCHAR(15) NOT NULL UNIQUE,
    H_Email VARCHAR(100) UNIQUE NOT NULL,
    CityId int,
    StateID int,
    CountryID int,
    FOREIGN KEY (CityId) REFERENCES City(CityId),
    FOREIGN KEY (StateID) REFERENCES State(StateID),
    FOREIGN KEY (CountryID) REFERENCES Country(CountryID)
);

-- 2. specialization table
use appointment;
CREATE TABLE specialization (
    specializationID INT AUTO_INCREMENT PRIMARY KEY,
    SpecialtyName VARCHAR(100) NOT NULL UNIQUE
);

-- 3. Create the AppointmentStatus table
use appointment;
CREATE TABLE AppointmentStatus (
    StatusID INT AUTO_INCREMENT PRIMARY KEY,
    StatusName VARCHAR(50) NOT NULL UNIQUE
);

-- 4. city table
use appointment; 
CREATE TABLE city(
	CityID INT PRIMARY KEY AUTO_INCREMENT,
    city varchar(50) NOT NULL UNIQUE
);

-- 5. state table
use appointment; 
CREATE TABLE state(
	StateID INT PRIMARY KEY AUTO_INCREMENT,
    State varchar(50) NOT NULL UNIQUE
);

-- 6. country table
use appointment; 
CREATE TABLE country(
	CountryID INT PRIMARY KEY AUTO_INCREMENT,
    Country varchar(50) NOT NULL UNIQUE
);

-- 7. Doctor table
use appointment;
CREATE TABLE Doctor (
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    D_Phone VARCHAR(15) NOT NULL UNIQUE,
    D_Email VARCHAR(100) NOT NULL UNIQUE,
    D_Password VARCHAR(12) NOT NULL UNIQUE,  
    HospitalID INT,
    specializationID INT,
    FOREIGN KEY (HospitalID) REFERENCES Hospital(HospitalID),
    FOREIGN KEY (specializationID) REFERENCES specialization(specializationID)
);

-- 8. Patients Table
use appointment;
CREATE TABLE Patients (
    PatientID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    P_Phone VARCHAR(15) NOT NULL UNIQUE,
    P_Email VARCHAR(100) NOT NULL UNIQUE,
	P_Password VARCHAR(12) NOT NULL UNIQUE
);

-- 9. Appointments table
use appointment;
CREATE TABLE Appointments (
    AppointmentID INT AUTO_INCREMENT PRIMARY KEY,
    DoctorID INT,
    PatientID INT,
    AppointmentDate DATETIME,
    Reason VARCHAR(255),
    StatusID INT,
    FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (StatusID) REFERENCES AppointmentStatus(StatusID)
);