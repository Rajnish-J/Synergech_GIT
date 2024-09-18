-- PROBLEM 1

use training_assignments;

SELECT Passenger_name,Passenger_id,Passenger_mobile FROM passenger_info
WHERE state ='Chennai' and country = 'india';

-- ---------------------------------------------------------------------------------------

-- PROBLEM 2

use training_assignments;

SELECT Passenger_name FROM passenger_info
WHERE Passenger_Name LIKE 'Vim%';

-- ---------------------------------------------------------------------------------------

-- PROBLEM 3

use training_assignments;

SELECT Passenger_name FROM passenger_info
WHERE Passenger_Name LIKE '%th';

-- ---------------------------------------------------------------------------------------

-- PROBLEM 4

use training_assignments;

SELECT Passenger_name FROM passenger_info
WHERE Passenger_Name LIKE '%m%';

-- ---------------------------------------------------------------------------------------

-- PROBLEM 5

use training_assignments;

SELECT Passenger_name FROM passenger_info
WHERE Passenger_Name NOT LIKE '%s%';

-- ---------------------------------------------------------------------------------------

-- PROBLEM 6

use training_assignments;

SELECT * FROM bus_info
WHERE Bus_Destination IN ('Nagercoil','Tiruvandrum');

-- ---------------------------------------------------------------------------------------

-- PROBLEM 7

use training_assignments;

SELECT * FROM bus_info
WHERE Ticket_Fare BETWEEN 200 AND 400;

-- ---------------------------------------------------------------------------------------

-- PROBLEM 8

use training_assignments;

SELECT * FROM passenger_info
WHERE Passenger_Gender IS null;

-- ---------------------------------------------------------------------------------------

-- PROBLEM 9

use training_assignments;

SELECT * FROM bus_info
WHERE Total_No_Of_Seats>25 AND Ticket_Fare<300;

-- ---------------------------------------------------------------------------------------

-- PROBLEM 10

use training_assignments;

SELECT * FROM bus_info
WHERE Total_No_Of_Seats>25 OR Ticket_Fare>300;