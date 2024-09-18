-- PROBLEM-1

use training_assignments;
SELECT country,COUNT(1) FROM passenger_info
GROUP BY Country;

-- --------------------------------------------------------------------------------

-- PROBLEM-2

use training_assignments;
SELECT city,count(1) FROM passenger_info
GROUP BY city ORDER BY count(1) desc LIMIT 1;

-- --------------------------------------------------------------------------------

-- PROBLEM-3

use training_assignments;
SELECT DISTINCT(Passenger_Name) From passenger_info;

-- --------------------------------------------------------------------------------

-- PROBLEM-4

use training_assignments;

SELECT city, GROUP_CONCAT(DISTINCT(passenger_Name)) AS passenger_names FROM passenger_info
GROUP BY city;

-- --------------------------------------------------------------------------------

-- PROBLEM-5

use training_assignments;
SELECT b.Bus_Source, SUM(t.Amount_Paid) AS total_fare FROM bus_info b 
LEFT JOIN ticket_info t using(Bus_Number)
GROUP BY b.Bus_Source; 

-- --------------------------------------------------------------------------------

-- PROBLEM-6

use training_assignments;
SELECT bi.Bus_Source, MIN(ti.Amount_Paid) AS Min_Amount_Paid FROM ticket_info ti 
RIGHT JOIN bus_info bi ON ti.Bus_Number = bi.Bus_Number
GROUP BY bi.Bus_Source;

-- --------------------------------------------------------------------------------
-- PROBLEM-7

use training_assignments;
SELECT * FROM ticket_info
ORDER BY Amount_paid DESC;

-- --------------------------------------------------------------------------------

-- PROBLEM-8

use training_assignments;
SELECT city,country,Count(1) FROm Passenger_info
group by city,country;

-- --------------------------------------------------------------------------------
-- PROBLEM-9

use training_assignments;
SELECT bi.Bus_Source, sum(ti.Amount_Paid) AS Total_Amount_Paid FROM ticket_info ti 
RIGHT JOIN bus_info bi ON ti.Bus_Number = bi.Bus_Number
GROUP BY bi.Bus_Source;

-- --------------------------------------------------------------------------------

-- PROBLEM-10

use training_assignments;
SELECT b.bus_source,AVG(t.Amount_paid) FROM bus_info b INNER JOIN ticket_info t Using(Bus_Number)
GROUP BY b.Bus_Source;

-- --------------------------------------------------------------------------------

-- PROBLEM-11

use training_assignments;
SELECT p.city,sum(t.No_Of_Tickets) as total_ticket FROM passenger_info p 
LEFT JOIN ticket_info t USING(Passenger_id)
GROUP By p.city ORDER by total_ticket DESC LIMIT 1;
-- --------------------------------------------------------------------------------

-- PROBLEM-12

use training_assignments;
SELECT p.Passenger_Name,P.Passenger_Id,sum(t.Amount_paid) FROM passenger_info p 
INNER JOIN ticket_info t using(Passenger_id)
GROUP BY Passenger_Id,Passenger_Name;