DROP TABLE IF EXISTS users;  
CREATE TABLE users (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
email VARCHAR(50) NOT NULL,  
pass VARCHAR(50) NOT NULL
);  