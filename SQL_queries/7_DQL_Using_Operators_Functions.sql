-- PROBLEM-1

use training_assignments;
SELECT concat('The Passenger ID is ',passenger_id,' AGE ',Passenger_Age,' and address is ',street,city ) as Passenger_details from passenger_info;

-- ----------------------------------------------------------------------
-- PROBLEM-2

use training_assignments;
SELECT ticket_id,concat(month(Date_of_Booking),'/',day(Date_of_Booking),'/',year(Date_of_Booking)) as Date From ticket_info;

-- ----------------------------------------------------------------------
-- PROBLEM-3

use training_assignments;
SELECT Ticket_id,bus_Number,Passenger_Id,No_OF_Tickets,round(Amount_Paid,2) as Amount,date_Of_Booking FROM ticket_info;

-- ----------------------------------------------------------------------
-- PROBLEM-4

use training_assignments;
SELECT passenger_id,upper(passenger_Name),Passenger_Gender,Passenger_Age,Passenger_Mobile,street,city,passenger_dob from passenger_info;

-- ----------------------------------------------------------------------
-- PROBLEM-5

use training_assignments;
SELECT passenger_id,substr(passenger_name,1,3) AS FPassenger_Name,Passenger_Gender,Passenger_Age,Passenger_Mobile, street,city,passenger_dob FROM passenger_info;

-- ----------------------------------------------------------------------
-- PROBLEM-6

use training_assignments;
SELECT concat(bus_Source,'-',bus_Destination)  From bus_info; 

-- ----------------------------------------------------------------------
-- PROBLEM-7

use training_assignments;
SELECT CURDATE();

-- ----------------------------------------------------------------------
-- PROBLEM-8

use training_assignments;
SELECT sum(Amount_paid) From ticket_info;

-- ----------------------------------------------------------------------
-- PROBLEM-9

use training_assignments;
SELECT count(1) from bus_info;

-- ----------------------------------------------------------------------
-- PROBLEM-10

use training_assignments;
SELECT AVG(Amount_Paid) FROM ticket_info;

-- ----------------------------------------------------------------------
-- PROBLEM-11

use training_assignments;
SELECT t.* FROM passenger_info p 
JOIN ticket_info t using(Passenger_id)
WHERE p.Passenger_age BETWEEN 20 AND 30;

-- ----------------------------------------------------------------------
-- PROBLEM-12

use training_assignments;
SELECT distinct(t.bus_Number),t.ticket_id,t.date_of_Booking,p.passenger_Name FROM passenger_info p 
JOIN ticket_info t Using(Passenger_id), bus_info b 
JOIN ticket_info USING (bus_Number)
WHERE p.city !='Chennai' AND  Bus_Source ='Chennai' AND t.Amount_Paid>(SELECT AVG(Amount_Paid)
	FROM ticket_info);