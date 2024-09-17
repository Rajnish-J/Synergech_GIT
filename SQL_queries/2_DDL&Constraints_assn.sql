-- problem 1:

drop table bus_info;
drop table passenger_info;
drop table ticket_info;

-- problem 2:

use training_assignments;

create table Bus_Info
(Bus_Number varchar(20) primary key,
Bus_Name varchar(25) Not null,
Bus_Source varchar(25),
Bus_Destination varchar(25),
Total_NO_Of_Seats int(3) default 40,
Ticket_Fare double(10,2),
Date_Of_Travel Date
);

-- -------------------------------------------------------------

-- problem 3:

use training_assignments;

create table Passenger_Info
(Passenger_Id varchar(20) primary key,
passenger_Name varchar(20) Not null,
passenger_Gender char(7),
passenger_Age int(3) check(passenger_Age >= 14 and passenger_Age <=99),
passenger_Address varchar(99),
passenger_Mobile varchar(15) unique,
Date_Of_Booking Date
);

-- -------------------------------------------------------------

-- problem 4:    

use training_assignments;

create table Ticket_Info
(Ticket_Id varchar(15) primary key,
Bus_Number varchar(20),
Passenger_Id varchar(20),
No_of_Tickets int(3) check(No_of_Tickets >= 1 and No_of_Tickets<= 8),
Amount_Pain double(10,2),
 FOREIGN KEY (Bus_Number) REFERENCES Bus_Info(Bus_Number),
  FOREIGN KEY (Passenger_Id) REFERENCES passenger_Info(Passenger_Id)
);

-- -------------------------------------------------------------

-- problem 5:    

ALTER TABLE Passenger_Info
DROP COLUMN Date_Of_Booking;

ALTER TABLE Ticket_Info
ADD Date_Of_Booking DATE;

-- -------------------------------------------------------------

ALTER TABLE Passenger_Info
DROP COLUMN Passenger_Address;

ALTER TABLE Passenger_Info
ADD street VARCHAR(50),
ADD city VARCHAR(30),
ADD state VARCHAR(30),
ADD country VARCHAR(30);

-- -------------------------------------------------------------

ALTER TABLE Bus_Info
DROP COLUMN Date_Of_Travel;

use training_assignments;

CREATE TABLE days_of_travel (
    Bus_Number VARCHAR(20),
    Day_Of_Travel INT CHECK (Day_Of_Travel BETWEEN 1 AND 7),
    PRIMARY KEY (Bus_Number, Day_Of_Travel),
    FOREIGN KEY (Bus_Number) REFERENCES Bus_Info(Bus_Number)
);