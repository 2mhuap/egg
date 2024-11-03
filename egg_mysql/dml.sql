-- Setiembre 11 2024
USE mi_bd;

SELECT * FROM empleados;
DESCRIBE empleados;

SELECT * FROM departamentos;
DESCRIBE departamentos;

-- INSERTANDO DEPARTAMENTOS
INSERT INTO departamentos (nombre) VALUES ('Ventas');
INSERT INTO departamentos (nombre) VALUES ('Recursos Humanos');

-- INSERTANDO EMPLEADOS
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Ana', 'Rodríguez', 28, 3000, 'anarodriguez@mail.com', 1);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Carlos', 'López', 32, 3200.50, 'carloslopez@mail.com', 2);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Laura', 'Pérez', 26, 2800.75, 'lauraperez@mail.com', 1);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Martín', 'Gonzaléz', 30, 3100.25, 'martingonzalez@mail.com', 2);

-- ACTUALIZA SALARIO DE Ana AUMENTANDO 10%
UPDATE empleados SET salario = salario + salario * (10/100) WHERE nombre = 'Ana';

-- Carlos -> Contabilidad
INSERT INTO departamentos (nombre) VALUES ('Contabilidad');
UPDATE empleados SET departamento_id = 3 WHERE nombre = 'Carlos';

-- ELIMINAR EMPLEADO
DELETE FROM empleados WHERE nombre = 'Laura';