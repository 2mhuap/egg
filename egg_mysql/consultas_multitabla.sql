-- Setiembre 17
USE mi_bd;
DESCRIBE ventas;

SELECT e.nombre, apellido, edad, salario, d.nombre
FROM empleados AS e, departamentos AS d
WHERE e.departamento_id = d.id;

SELECT v.id, producto_id, cliente_id, cantidad, precio_unitario, monto_total, CONCAT(e.nombre, ' ', e.apellido) AS empleado
FROM ventas AS v, empleados AS e
WHERE v.empleado_id = e.id;

SELECT v.id, p.nombre AS producto, cliente_id, cantidad, precio_unitario, monto_total, empleado_id
FROM ventas AS v, productos AS p
WHERE v.producto_id = p.id;

SELECT v.id, producto_id, c.nombre AS cliente, cantidad, precio_unitario, monto_total, empleado_id
FROM ventas AS v, clientes AS c
WHERE v.cliente_id = c.id;

SELECT v.id, producto_id, cliente_id, cantidad, precio_unitario, monto_total, CONCAT(e.nombre, ' ', e.apellido) AS empleado, d.nombre AS departamento
FROM ventas AS v, empleados AS e, departamentos AS d
WHERE v.empleado_id = e.id AND e.departamento_id = d.id;

SELECT v.id, p.nombre AS producto, c.nombre AS cliente, cantidad, precio_unitario, monto_total, CONCAT(e.nombre, ' ', e.apellido) AS empleado
FROM ventas AS v, empleados AS e, productos AS p, clientes AS c
WHERE v.empleado_id = e.id AND v.producto_id = p.id AND v.cliente_id = c.id;

SELECT d.nombre, MAX(salario)
FROM departamentos as d, empleados as e
WHERE e.departamento_id = d.id
GROUP BY departamento_id;

-- PARTE 2

SELECT d.nombre, SUM(monto_total)
FROM ventas v, empleados e, departamentos d
WHERE v.empleado_id = e.id AND e.departamento_id = d.id
GROUP BY d.nombre;

SELECT d.nombre, MIN(edad)
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

SELECT p.nombre AS producto,
  CASE
    WHEN SUM(cantidad) < 5 THEN 'Bajo'
    WHEN SUM(cantidad) < 8 AND SUM(cantidad) >= 5 THEN 'Medio'
    ELSE 'Alto'
  END as categoria_volumen,
  SUM(cantidad)
FROM ventas v, productos p
WHERE v.producto_id = p.id
GROUP BY p.nombre;

-- *
SELECT c.nombre cliente, MAX(monto_total)
FROM clientes c, ventas v
WHERE v.cliente_id = c.id
GROUP BY c.nombre;

SELECT e.nombre empleado, AVG(precio_unitario)
FROM ventas v, empleados e
WHERE v.empleado_id = e.id
GROUP BY e.nombre;

SELECT d.nombre departamento, MIN(salario)
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

SELECT d.nombre departamento, AVG(salario)
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id AND e.edad > 30
GROUP BY d.nombre
HAVING AVG(salario) > 3320;

-- EJERCICIOS COMPLEMENTARIOS

SELECT e.nombre empleado, SUM(cantidad)
FROM ventas v, empleados e
WHERE v.empleado_id = e.id
GROUP BY e.nombre;

SELECT c.nombre cliente, SUM(monto_total)
FROM clientes c, ventas v
WHERE v.cliente_id = c.id
GROUP BY c.nombre;

SELECT p.nombre, precio_unitario
FROM ventas v, productos p
WHERE v.producto_id = p.id
ORDER BY precio_unitario DESC;
LIMIT 1;

SELECT d.nombre departamento, AVG(salario)
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

SELECT CONCAT(e.nombre, ' ', e.apellido) empleado, COUNT(v.id) total_ventas
FROM empleados e, ventas v
WHERE v.empleado_id = e.id
GROUP BY e.id
HAVING total_ventas > 5
ORDER BY total_ventas DESC;



