-- Setiembre 12
SELECT * FROM productos;
SELECT * FROM clientes;
SELECT * FROM empleados;
SELECT * FROM departamentos;
SELECT * FROM ventas;

SELECT DISTINCT edad FROM empleados;

-- OPERADORES RELACIONALES
SELECT nombre FROM empleados WHERE salario > 3200;
SELECT * FROM empleados WHERE edad = 28;
SELECT * FROM empleados WHERE salario < 2700;
SELECT * FROM ventas WHERE cantidad > 2;
SELECT * FROM ventas WHERE precio_unitario = 480;
SELECT * FROM ventas WHERE monto_total < 1000;
SELECT * FROM ventas WHERE empleado_id = 1;

-- OPERADORES LOGICOS
SELECT nombre FROM empleados WHERE departamento_id = 1 AND salario > 3000;
SELECT nombre FROM empleados WHERE edad = 32 OR departamento_id = 3;
SELECT * FROM ventas WHERE producto_id = 1 AND cantidad >= 2;
SELECT * FROM ventas WHERE cliente_id = 1 OR empleado_id = 2;
SELECT * FROM ventas WHERE cliente_id = 3 AND cantidad > 2;
SELECT * FROM ventas WHERE cliente_id = 1 AND monto_total > 2000;

-- BETWEEN
SELECT nombre, edad FROM empleados WHERE edad BETWEEN 29 AND 33;
SELECT * FROM ventas WHERE cantidad BETWEEN 2 AND 3;
SELECT * FROM ventas WHERE precio_unitario BETWEEN 300 AND 500;



