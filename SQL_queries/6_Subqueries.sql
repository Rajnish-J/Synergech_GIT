-- PROBLEM-1

use training_assignment;

SELECT b.* FROM bus_info b 
INNER JOIN ticket_info t ON b.Bus_Number=t.Bus_Number 
WHERE t.Amount_Paid=(
	SELECT max(Amount_Paid) FROM Ticket_info);
    
-- --------------------------------------------------------------------------
-- PROBLEM-2

use training_assignment;

SELECT p.Passenger_id,p.Passenger_Name FROM Passenger_info p 
INNER JOIN  ticket_info t  ON p.Passenger_Id=t.Passenger_Id  
WHERE No_of_Tickets IN(
	SELECT max(No_OF_Tickets) FROM ticket_info);
-- --------------------------------------------------------------------------

-- PROBLEM-3

use training_assignment;

SELECT * FROM bus_info 
WHERE Bus_Number IN (SELECT Bus_Number from ticket_info 
	WHERE Amount_Paid >(SELECT avg(Amount_Paid) FROM ticket_info));