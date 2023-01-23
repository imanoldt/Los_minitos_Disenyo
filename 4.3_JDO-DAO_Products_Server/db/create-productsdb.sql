/* DELETE 'productsDB2' database*/
DROP SCHEMA IF EXISTS productsDB2;
/* DELETE USER 'products_user2' AT LOCAL SERVER*/
DROP USER IF EXISTS 'products_user2'@'%';

/* CREATE ''productsDB2' DATABASE */
CREATE SCHEMA IF NOT EXISTS productsDB2;
/* CREATE THE USER 'products_user2' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER IF NOT EXISTS 'products_user2'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user2' AT LOCAL SERVER*/
GRANT ALL ON productsDB2.* TO 'products_user2'@'%';