-- ---------------------------------------------------------------------------------------
-- problem 1:

use training_assignments;

SELECT b.bus_number, b.bus_name, t.ticket_id FROM training_assignments.ticket_info t
LEFT JOIN training_assignments.bus_info b ON t.Bus_Number = b.Bus_Number;
-- ---------------------------------------------------------------------------------------
-- problem 2:

use training_assignments;

select b.bus_name,b.bus_Number,p.passenger_Name FROM ticket_info t 
LEFT JOIN bus_info b on t.Bus_Number=b.Bus_Number
LEFT JOIN passenger_info p ON p.Passenger_Id=t.Passenger_Id;

-- ---------------------------------------------------------------------------------------
-- problem 3:

use training_assignments;

select b.bus_name,b.bus_Number,p.passenger_Name FROM ticket_info t 
LEFT JOIN bus_info b on t.Bus_Number=b.Bus_Number
LEFT JOIN passenger_info p ON p.Passenger_Id=t.Passenger_Id
WHERE t.Amount_Paid>300;

-- ---------------------------------------------------------------------------------------
-- problem 4:

use training_assignments;

select b.bus_name,b.bus_Number,p.passenger_Name FROM ticket_info t 
LEFT JOIN bus_info b on t.Bus_Number=b.Bus_Number
LEFT JOIN passenger_info p ON p.Passenger_Id=t.Passenger_Id
WHERE t.Date_Of_Booking BETWEEN '2012-03-01' AND '2012-04-30';

-- ---------------------------------------------------------------------------------------
-- problem 5:

use training_assignments;

select b.bus_name,b.bus_Number,p.passenger_Name FROM ticket_info t 
LEFT JOIN bus_info b on t.Bus_Number=b.Bus_Number
LEFT JOIN passenger_info p ON p.Passenger_Id=t.Passenger_Id
WHERE t.Amount_Paid>300 OR p.city='Chennai';

-- ---------------------------------------------------------------------------------------
-- problem 6:

use training_assignments;

SELECT b.bus_Name,p.Passenger_Name,t.Ticket_Id FROM bus_info b 
RIGHT JOIN ticket_info t USING(bus_Number) 
JOIN passenger_info p USING(passenger_Id);

-- ---------------------------------------------------------------------------------------
-- problem 7:

use training_assignments;

select DISTINCT(t.Ticket_Id),b.bus_name,p.passenger_Name FROM ticket_info t 
INNER JOIN bus_info b on t.Bus_Number=b.Bus_Number
INNER JOIN passenger_info p ON p.Passenger_Id=t.Passenger_Id
INNER JOIN days_of_travel d ON b.Bus_Number=d.Bus_Number
WHERE d.day_of_travel IN (1,4,5);

-- ---------------------------------------------------------------------------------------
-- problem 8:

use training_assignments;

SELECT p.passenger_id,coalesce(t.No_Of_Tickets,0) AS Number_OF_Ticket_BOOKED FROM passenger_info p 
LEFT JOIN ticket_info t ON p.passenger_id=t.Passenger_Id;

-- ---------------------------------------------------------------------------------------
-- problem 9:

use training_assignments;

SELECT   t1.passenger_id AS Passenger_1, t2.passenger_id AS Passenger_2, t1.bus_number AS Bus_Number FROM ticket_info t1 
JOIN ticket_info AS t2 ON t1.bus_number = t2.bus_number 
AND t1.passenger_id <= t2.passenger_id;

-- ---------------------------------------------------------------------------------------
-- problem 10:

use training_assignments;

SELECT B.Bus_Number,coalesce(SUM(t.Amount_Paid),0) as Total_Amount FROM ticket_info t 
RIGHT JOIN bus_info b ON t.Bus_Number=b.Bus_Number
Group BY b.Bus_Number;
