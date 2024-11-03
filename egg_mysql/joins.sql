-- Setiembre 18
USE mi_bd;

-- PARTE 1

SELECT e.nombre, e.apellido, SUM(v.cantidad) cantidad_ventas
FROM empleados e
INNER JOIN ventas v
ON v.empleado_id = e.id
GROUP BY e.id;

SELECT c.nombre, c.direccion, SUM(v.monto_total)
FROM clientes c
LEFT JOIN ventas v ON v.cliente_id = c.id
GROUP BY c.id;

SELECT e.nombre empleado, p.nombre producto
FROM empleados e
INNER JOIN ventas v
  ON v.empleado_id = e.id
INNER JOIN productos p
  ON v.producto_id = p.id
WHERE e.departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas');

SELECT c.nombre cliente, p.nombre producto, SUM(v.cantidad) cantidad
FROM clientes c
INNER JOIN ventas v
  ON v.cliente_id = c.id
INNER JOIN productos p
  ON v.producto_id = p.id
WHERE v.precio_unitario > 500
GROUP BY c.id, p.id;

-- PARTE 2

SELECT d.nombre, COUNT(v.id) cantidad_ventas
FROM departamentos d
LEFT JOIN empleados e
  ON e.departamento_id = d.id
LEFT JOIN ventas v
  ON v.empleado_id = e.id
GROUP BY d.id;

SELECT c.nombre, c.direccion, COUNT(DISTINCT v.producto_id) compras
FROM clientes c
INNER JOIN ventas v
  ON v.cliente_id = c.id
GROUP BY c.id 
HAVING COUNT(DISTINCT v.producto_id) > 3;

SELECT d.nombre, SUM(v.monto_total) monto_total_ventas
FROM departamentos d
LEFT JOIN empleados e
  ON e.departamento_id = d.id
LEFT JOIN ventas v
  ON v.empleado_id = e.id
GROUP BY d.id;

-- EJERCICIOS COMPLEMENTARIOS
SELECT e.nombre, e.apellido
FROM empleados e
INNER JOIN departamentos d
  ON e.departamento_id = d.id
INNER JOIN ventas v
  ON v.empleado_id = e.id
GROUP BY e.id
HAVING COUNT(v.id) > 5;

SELECT e.nombre, e.apellido, COUNT(v.id) cantidad_ventas
FROM empleados e
LEFT JOIN ventas v
  ON v.empleado_id = e.id
GROUP BY e.id;

-- *
SELECT d.nombre, e.nombre, e.edad
FROM departamentos d
INNER JOIN empleados e
  ON e.departamento_id = d.id
WHERE e.edad = (SELECT MIN(e.edad) FROM empleados e WHERE e.departamento_id = d.id);

-- Solucion YOSSEC YOSEFER SUAREZ ARRATEA
-- SELECT departamentos.nombre AS departamento, empleados.nombre, empleados.apellido, empleados.edad
-- FROM empleados
-- INNER JOIN departamentos ON empleados.departamento_id = departamentos.id
-- WHERE empleados.edad = (
-- SELECT MIN(edad)
-- FROM empleados e
-- WHERE e.departamento_id = empleados.departamento_id
-- )
-- ORDER BY departamentos.nombre;

SELECT p.nombre, SUM(cantidad) volumen,
  CASE
    WHEN SUM(cantidad) > 10 THEN 'Alto'
    WHEN SUM(cantidad) <= 10 AND SUM(cantidad) >= 5 THEN 'Medio'
    ELSE 'Bajo'
  END AS categoria_volumen
FROM productos p
LEFT JOIN ventas v
  ON v.producto_id = p.id
GROUP BY p.id;