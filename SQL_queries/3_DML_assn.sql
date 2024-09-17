-- problem 1:

use training_assignments;

insert into bus_info(bus_number,bus_name, bus_source, bus_destination, Total_no_of_seats, Ticket_fare) values 
('UD710', 'Nager Express', 'Chennai', 'Nagercoil', 40, 510), 
('UD210', 'Nellai Express', 'Chennai', 'Thirunelveli', 38, 460),
('UD510', 'Tutucorin Express', 'Chennai', 'Tutucorin', 40, 555),
('UD787', 'Cape Express', 'Madurai', 'Kanya Kumari', 31, 230),
('UD912', 'Ananthapuri Express', 'Coimbatore', 'Trivandrum', 37, 300);

-- ---------------------------------------------------------------------------------------------------------------------

--  problem 2:

use training_assignments;

insert into days_of_travel (Bus_Number, Day_Of_Travel) values
('UD710', 1),
('UD710', 3),
('UD710', 5),
('UD210', 2),
('UD210', 6),
('UD510', 1),
('UD510', 2),
('UD510', 3),
('UD510', 4),
('UD510', 5),
('UD510', 6),
('UD510', 7),
('UD787', 6),
('UD787', 7),
('UD912', 7);

-- ---------------------------------------------------------------------------------------------------------------------

-- problem 3:

use training_assignments;

insert into passenger_info (Passenger_Id, Passenger_Name, Passenger_Gender, Passenger_Age, street, city, state, country, Passenger_Mobile) values
('087676', 'Biju', 'Male', 23, 'Biju Villa', 'Okkiyam', 'Chennai', 'India', 98765656565),
('098434', 'Vimal', 'Male', 45, 'V.S.Nivas', 'K.K.Nagar', 'Nagercoil', 'India', 98765328656),
('018733', 'Vineeth', 'Female', 67, '320, Shanthi Colony', 'Anna Nagar', 'Chennai', 'India', 98762189565),
('094876', 'James', 'Male', 19, '23, Vishnu Illam', 'Majestic', 'Bangalore', 'India', 98926434565),
('094123', 'Reena', 'Female', 28, 'Arcade Gardens', 'Kochi', 'Kerala', 'India', 9541287563);

-- ---------------------------------------------------------------------------------------------------------------------

-- problem 4: 

use training_assignments;

insert into ticket_info (ticket_id, bus_number, passenger_id, no_of_tickets, amount_paid, date_of_booking) values
('898177', 'UD912', '094876', 4, 1200, '2012-03-19'),
('987676', 'UD710', '098434', 3, 1530, '2013-03-22'),
('812321', 'UD210', '087676', 2, 920, '2012-04-14'),
('987111', 'UD710', '018733', 3, 1665, '2012-03-29');

-- ---------------------------------------------------------------------------------------------------------------------

-- problem 5: 

use training_assignments;

ALTER TABLE passenger_info ADD COLUMN passenger_dob DATE;

UPDATE passenger_info
SET passenger_dob = (
    SELECT DATE_SUB(CONCAT(YEAR(NOW()), '-01-01'), INTERVAL 45 YEAR)
) WHERE passenger_id = '098434';

UPDATE passenger_info
SET passenger_dob = (
    SELECT DATE_SUB(CONCAT(YEAR(NOW()), '-01-01'), INTERVAL 67 YEAR)
) WHERE passenger_id = '018733';

UPDATE passenger_info
SET passenger_dob = (
    SELECT DATE_SUB(CONCAT(YEAR(NOW()), '-01-01'), INTERVAL 23 YEAR)
) WHERE passenger_id = '087676';

UPDATE passenger_info
SET passenger_dob = (
    SELECT DATE_SUB(CONCAT(YEAR(NOW()), '-01-01'), INTERVAL 19 YEAR)
) WHERE passenger_id = '094876';

UPDATE passenger_info
SET passenger_dob = (
    SELECT DATE_SUB(CONCAT(YEAR(NOW()), '-01-01'), INTERVAL 28 YEAR)
) WHERE passenger_id = '094123';

-- ---------------------------------------------------------------------------------------------------------------------