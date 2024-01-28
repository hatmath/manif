-- Use default port for development : 3306

-- Create Database
CREATE DATABASE IF NOT EXISTS manif_core;

-- Use the Database
USE manif_core;

-- Create Users and Grant Privileges
CREATE USER IF NOT EXISTS 'manif-data'@'%' IDENTIFIED BY 'manif123';
GRANT SELECT, INSERT, UPDATE, DELETE ON manif_core.* TO 'manif-data'@'%';

CREATE USER IF NOT EXISTS 'manif-admin'@'%' IDENTIFIED BY 'manif123';
GRANT ALL PRIVILEGES ON manif_core.* TO 'manif-admin'@'%';

CREATE USER IF NOT EXISTS 'adminUser'@'%' IDENTIFIED BY 'manif123';
GRANT ALL PRIVILEGES ON manif_core.* TO 'adminUser'@'%';

-- Flush Privileges
FLUSH PRIVILEGES;
