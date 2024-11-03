CREATE DATABASE mi_bd;

-- CREATE DATABASE mi_bd_2;
-- DROP DATABASE mi_bd_2;

USE mi_bd;

CREATE TABLE IF NOT EXISTS empleados (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  edad INT,
  salario DECIMAL(10,2),
  fecha_contratacion DATE
);

SHOW TABLES;
