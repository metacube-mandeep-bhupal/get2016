/* Creating database addressForm  */
CREATE DATABASE addressForm;
 
/*Using database addressForm */
USE addressForm;

/* Creating table named as address */
CREATE TABLE address(
zip_code int(6),
city_name VARCHAR(30),
state_name VARCHAR(30),
PRIMARY KEY(zip_code,state_name)
);

/* Inserting zipcode , city name and state name */
INSERT INTO address(zip_code,city_name,state_name)
VALUES ('302020','Jaipur','RAJASTHAN');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('302017','Mumbai','MAHARASHTRA');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('565648','Nagpur','MAHARASHTRA');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('484454','Jaipur','MADHYA PRADESH');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('436549','GandhiNagar','GUJARAT');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('321655','Ranchi','JHARKHAND');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('797985','Paali','RAJASTHAN');

INSERT INTO address(zip_code,city_name,state_name)
VALUES ('125316','Delhi','DELHI');

/* Showing details in order by state name and city name */
SELECT zip_code AS 'Pincode', city_name AS 'City Name', state_name AS 'State Name'
	FROM address
	ORDER BY  state_name, city_name;
