-- Setiembre 12
USE mi_bd;
SELECT * FROM productos;
SELECT * FROM clientes;
SELECT * FROM empleados;
SELECT * FROM departamentos;
DESCRIBE empleados;
SELECT * FROM ventas;

INSERT INTO productos (nombre, precio)
VALUES ('Teléfono móvil', 450);
INSERT INTO clientes (nombre, direccion)
VALUES ('María García', 'Constitución 456, Luján');

ALTER TABLE empleados
MODIFY correo_electronico VARCHAR(100) GENERATED ALWAYS AS (CONCAT(nombre, apellido, '@mail.com')) STORED;

INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Luis', 'Fernández', 28, 2800, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

UPDATE productos SET precio = 1350 WHERE nombre = 'Laptop';
UPDATE clientes SET direccion = 'Alberti 1789, Mar del Plata' WHERE nombre = 'Juan Pérez';

UPDATE empleados SET salario = salario + (salario * 5/100); 

INSERT INTO productos (nombre, precio)
VALUES ('Tablet', 350);
INSERT INTO clientes (nombre, direccion)
VALUES ('Ana López', 'Beltrán 1452, Godoy Cruz');
INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Marta', 'Ramírez', 32, 3100, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

UPDATE productos SET precio = 480 WHERE nombre = 'Teléfono móvil';
UPDATE clientes SET direccion = 'Avenida 789, Ciudad del Este' WHERE nombre = 'María García';

UPDATE empleados SET salario = salario + (salario * 7/100) WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas'); 

INSERT INTO productos (nombre, precio)
VALUES ('Impresora', 280);
INSERT INTO clientes (nombre, direccion)
VALUES ('Carlos Sánchez', 'Saavedra 206, Las Heras');
INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Lorena', 'Guzmán', 26, 2600, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

SELECT * FROM ventas;
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Laptop"),
  (SELECT id FROM clientes WHERE nombre = "Juan Pérez"),
  2,
  (SELECT precio FROM productos WHERE nombre = "Laptop"),
  (SELECT id FROM empleados WHERE nombre = "Ana")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Teléfono móvil"),
  (SELECT id FROM clientes WHERE nombre = "María García"),
  3,
  (SELECT precio FROM productos WHERE nombre = "Teléfono móvil"),
  (SELECT id FROM empleados WHERE nombre = "Carlos" AND apellido = "López")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Impresora"),
  (SELECT id FROM clientes WHERE nombre = "Carlos Sánchez"),
  1,
  (SELECT precio FROM productos WHERE nombre = "Impresora"),
  (SELECT id FROM empleados WHERE nombre = "Marta" AND apellido = "Ramírez")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Laptop"),
  (SELECT id FROM clientes WHERE nombre = "Ana López"),
  1,
  (SELECT precio FROM productos WHERE nombre = "Laptop"),
  (SELECT id FROM empleados WHERE nombre = "Carlos" AND apellido = "López")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Tablet"),
  (SELECT id FROM clientes WHERE nombre = "Juan Pérez"),
  2,
  (SELECT precio FROM productos WHERE nombre = "Tablet"),
  (SELECT id FROM empleados WHERE nombre = "Luis" AND apellido = "Fernández")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Teléfono móvil"),
  (SELECT id FROM clientes WHERE nombre = "María García"),
  1,
  (SELECT precio FROM productos WHERE nombre = "Teléfono móvil"),
  (SELECT id FROM empleados WHERE nombre = "Marta" AND apellido = "Ramírez")
);
INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
  (SELECT id FROM productos WHERE nombre = "Impresora"),
  (SELECT id FROM clientes WHERE nombre = "Carlos Sánchez"),
  2,
  (SELECT precio FROM productos WHERE nombre = "Impresora"),
  (SELECT id FROM empleados WHERE nombre = "Lorena" AND apellido = "Guzmán")
);
-- DELETE FROM empleados WHERE id = 6;