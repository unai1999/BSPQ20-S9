DROP SCHEMA IF EXISTS pisosDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA pisosDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON pisosDB.* TO 'spq'@'localhost';