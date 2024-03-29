CREATE TABLE user (
userid INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(30) NOT NULL,
username VARCHAR(30) NOT NULL,
password VARCHAR(50),
confirm_password VARCHAR(50)
);

CREATE TABLE category (
category_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
category_desc VARCHAR(30) NOT NULL,
category_name VARCHAR(30) NOT NULL
);

CREATE TABLE expense (
expense_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
expense_amount VARCHAR(30) NOT NULL,
expense_type VARCHAR(30) NOT NULL,
expensedate DATE DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (userid) REFERENCES user(userid),
FOREIGN KEY (category_id) REFERENCES category(category_id)
);


