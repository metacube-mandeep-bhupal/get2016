/* Creating the database */
CREATE DATABASE Menu;

/* Selecting the database */
USE Menu;

/* Creting the category table */
CREATE TABLE Category(
	category_id VARCHAR(20),
	category_name VARCHAR(30) NOT NULL,
	parent_category VARCHAR(20),
	PRIMARY KEY(category_id)
);

/* Inserting the values into the table */
INSERT INTO Category VALUE ('1', 'Mobiles and Tablets', NULL);
INSERT INTO Category VALUE ('2', 'Mobiles', '1');
INSERT INTO Category VALUE ('3', 'Tablets', '1');

INSERT INTO category VALUE ('4', 'Smart Phones', '2');
INSERT INTO category VALUE ('5', 'Featured Phones', '2');
INSERT INTO category VALUE ('6', '2G', '3');
INSERT INTO category VALUE ('7', '3G', '3');

INSERT INTO category VALUE ('8', 'Accesories', '1');
INSERT INTO category VALUE ('9', 'Cases and Covers', '1');

INSERT INTO category VALUE ('10', 'Computers', NULL);
INSERT INTO category VALUE ('11', 'Desktop', '10');
INSERT INTO category VALUE ('12', 'Laptop', '10');
INSERT INTO category VALUE ('13', 'Laptop Accessories', '10');
INSERT INTO category VALUE ('14', 'Printer', '10');
INSERT INTO category VALUE ('15', 'Keyboard', '13');
INSERT INTO category VALUE ('16', 'Mouse', '13');
INSERT INTO category VALUE ('17', 'Headphones', '13');
INSERT INTO category VALUE ('18', 'Inkjet', '14');
INSERT INTO category VALUE ('19', 'Laser', '14');

/* To display all the categories along with their parent category */
SELECT c1.category_name AS 'Category', c2.category_name AS 'Parent Category'
	FROM Category c1
	LEFT JOIN Category c2 ON c1.parent_category = c2.category_id;

/* To display all the categories along with their parent category,
 * sorted on the basis of parent category */
SELECT c1.category_name AS 'Category', c2.category_name AS 'Parent Category'
	FROM Category c1
	LEFT JOIN Category c2 ON c1.parent_category = c2.category_id
	ORDER BY c2.category_name;
	
/* To display all the categories along with their parent category.
 * If it is top category then display  'Top Category' for parent category */
SELECT c1.category_name AS 'Category', IFNULL(c2.category_name, 'Top Category') AS 'Parent Category'
	FROM Category c1
	LEFT JOIN Category c2 ON c1.parent_category = c2.category_id
	ORDER BY c2.category_name;

/* To display only the top categories. */
SELECT category_name 
	FROM Category
	WHERE parent_category IS NULL;
