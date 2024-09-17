create database training_assignments;

-- problem 1: 

use training_assignments;

create table Bus_Info
(Bus_Number varchar(20) primary key,
Bus_Name varchar(25),
Bus_Source varchar(25),
Bus_Destination varchar(25),
Total_NO_Of_Seats int(3),
Ticket_Fare double(10,2),
Date_Of_Travel Date
);

-- -------------------------------------------------------------

-- problem 2:   

use training_assignments;

create table Passenger_Info
(Passenger_Id varchar(20) primary key,
passenger_Name varchar(20),
passenger_Gender char(7),
passenger_Age int(3),
passenger_Address varchar(99),
passenger_Mobile varchar(15),
Date_Of_Booking Date
);

-- -------------------------------------------------------------

-- problem 3:   

use training_assignments;

create table Ticket_Info
(Ticket_Id varchar(15) primary key,
Bus_Number varchar(20),
Passenger_Id varchar(20),
No_of_Tickets int(3),
Amount_Pain double(10,2)
);