
use hos_check;
INSERT INTO hospital (hospital_id, hospital_name, hospital_phone, hospital_email, city_id, state_id, country_id, created_At, updated_At) 
VALUES
(1, 'City Hospital', '9876543210', 'info@cityhospital.com', 1, 1, 1, '2023-01-01', '2023-01-01'),
(2, 'Metro Medical Center', '9876543211', 'contact@metromedical.com', 2, 2, 1, '2023-01-02', '2023-01-02'),
(3, 'Sunrise Clinic', '9876543212', 'hello@sunriseclinic.com', 3, 3, 1, '2023-01-03', '2023-01-03'),
(4, 'Global Health Care', '9876543213', 'support@globalhealth.com', 1, 1, 2, '2023-01-04', '2023-01-04'),
(5, 'Care Hospital', '9876543214', 'info@carehospital.com', 2, 2, 2, '2023-01-05', '2023-01-05');

use hos_check;
INSERT INTO specialization (specialization_id, specialization) 
VALUES
(1, 'Cardiology'),
(2, 'Dermatology'),
(3, 'Orthopedics'),
(4, 'Neurology'),
(5, 'Pediatrics');

use hos_check;
INSERT INTO AppointmentStatus (status_id, Status_Name) 
VALUES
(1, 'Scheduled'),
(2, 'Completed'),
(3, 'Cancelled'),
(4, 'Pending'),
(5, 'Confirmed');


use hos_check;
INSERT INTO city (city_id, city) 
VALUES
(1, 'New York'),
(2, 'Los Angeles'),
(3, 'Chicago'),
(4, 'Houston'),
(5, 'Phoenix');

use hos_check;
INSERT INTO state (state_id, State) 
VALUES
(1, 'New York'),
(2, 'California'),
(3, 'Illinois'),
(4, 'Texas'),
(5, 'Arizona');

use hos_check;
INSERT INTO country (country_id, Country) 
VALUES
(1, 'United States'),
(2, 'Canada'),
(3, 'United Kingdom'),
(4, 'Australia'),
(5, 'India');

use hos_check;
INSERT INTO Doctor (doctor_id, first_name, last_name, doc_phone, doc_email, doc_password, hospital_id, specialization_id, created_At, updated_At) 
VALUES
(1, 'John', 'Doe', '8881234567', 'johndoe@hospital.com', 'passJohn1', 1, 1, '2023-01-01', '2023-01-01'),
(2, 'Jane', 'Smith', '8881234568', 'janesmith@hospital.com', 'passJane2', 2, 2, '2023-01-02', '2023-01-02'),
(3, 'Robert', 'Williams', '8881234569', 'robertw@hospital.com', 'passRob3', 3, 3, '2023-01-03', '2023-01-03'),
(4, 'Emily', 'Davis', '8881234570', 'emilydavis@hospital.com', 'passEm4', 4, 4, '2023-01-04', '2023-01-04'),
(5, 'Michael', 'Brown', '8881234571', 'michaelb@hospital.com', 'passMike5', 5, 5, '2023-01-05', '2023-01-05');

use hos_check;
INSERT INTO Patients (patient_id, first_name, last_name, dob, patient_phone, patient_email, patient_password, created_At, updated_At) 
VALUES
(1, 'Alice', 'Johnson', '1990-05-10', '7776543210', 'alice@patients.com', 'Alice1234', '2023-01-01', '2023-01-01'),
(2, 'Bob', 'Miller', '1988-08-22', '7776543211', 'bob@patients.com', 'Bob5678', '2023-01-02', '2023-01-02'),
(3, 'Charlie', 'Wilson', '1995-07-15', '7776543212', 'charlie@patients.com', 'Char9012', '2023-01-03', '2023-01-03'),
(4, 'Diana', 'Moore', '1992-03-30', '7776543213', 'diana@patients.com', 'Diana3456', '2023-01-04', '2023-01-04'),
(5, 'Edward', 'Taylor', '1998-11-11', '7776543214', 'edward@patients.com', 'Edwa7890', '2023-01-05', '2023-01-05');

use hos_check;
INSERT INTO Appointments (appointment_id, doctor_id, patient_id, appointment_date, reason, created_At, updated_At) 
VALUES
(1, 1, 1, '2023-02-01 10:00:00', 'Regular Checkup', '2023-01-01', '2023-01-01'),
(2, 2, 2, '2023-02-02 11:00:00', 'Skin Issue', '2023-01-02', '2023-01-02'),
(3, 3, 3, '2023-02-03 12:00:00', 'Back Pain', '2023-01-03', '2023-01-03'),
(4, 4, 4, '2023-02-04 13:00:00', 'Headache', '2023-01-04', '2023-01-04'),
(5, 5, 5, '2023-02-05 14:00:00', 'Child Vaccination', '2023-01-05', '2023-01-05');