-- Setiembre 16
USE mi_bd;

-- MAX
SELECT MAX(salario) FROM empleados;
SELECT MAX(cantidad) FROM ventas;
SELECT MAX(edad) FROM empleados;

-- MIN
SELECT MIN(salario) FROM empleados;
SELECT MIN(cantidad) FROM ventas;
SELECT MIN(edad) FROM empleados;

-- COUNT
SELECT COUNT(*) FROM empleados;
SELECT COUNT(*) FROM ventas;
SELECT COUNT(*) FROM productos WHERE precio > 500;

-- SUM
SELECT SUM(salario) FROM empleados;
SELECT SUM(cantidad) FROM ventas;
SELECT SUM(precio) FROM productos WHERE id % 2 = 0;

-- AVG
SELECT AVG(salario) FROM empleados;
SELECT AVG(precio) FROM productos;
SELECT AVG(edad) FROM empleados;

-- GROUP BY
SELECT empleado_id, COUNT(*) AS cantidad_ventas FROM ventas GROUP BY empleado_id;
SELECT precio, COUNT(*) FROM productos GROUP BY precio;
SELECT departamento_id, COUNT(*) FROM empleados GROUP BY departamento_id;

-- HAVING
SELECT departamento_id, AVG(salario) FROM empleados GROUP BY departamento_id HAVING AVG(salario) > 3000;

SELECT producto_id, (SELECT nombre FROM productos WHERE id = producto_id), COUNT(*)
FROM ventas GROUP BY producto_id HAVING COUNT(*) >= 5;

SELECT departamento_id, MAX(salario) FROM empleados WHERE LOWER(nombre) LIKE '%o%' OR LOWER(apellido) LIKE '%o%'
GROUP BY departamento_id HAVING MAX(salario) = MAX(salario);
