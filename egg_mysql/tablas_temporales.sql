-- Setiembre 19
USE mi_bd;

TABLE productos ORDER BY precio DESC LIMIT 10;
DESCRIBE empleados;

CREATE TEMPORARY TABLE empleados_Temporal AS
SELECT CONCAT(nombre, ' ', apellido) nombre_apellido
FROM empleados;

TABLE empleados_Temporal;

CREATE TEMPORARY TABLE clientes_Temporal AS
SELECT nombre FROM clientes;

TABLE clientes_Temporal;

TABLE empleados_Temporal UNION TABLE clientes_Temporal;

CREATE TEMPORARY TABLE escuela_primaria_Temporal AS
VALUES
  ROW(1, 'Alejandro', 'González', 11, 5),
  ROW(2, 'Isabella', 'López', 10, 4),
  ROW(3, 'Lucas', 'Martínez', 11, 5),
  ROW(4, 'Sofía', 'Rodríguez', 10, 4),
  ROW(5, 'Mateo', 'Pérez', 12, 6),
  ROW(6, 'Valentina', 'Fernández', 12, 6),
  ROW(7, 'Diego', 'Torres', 10, 4),
  ROW(8, 'Martina', 'Gómez', 11, 5),
  ROW(9, 'Joaquín', 'Hernández', 10, 4),
  ROW(10, 'Valeria', 'Díaz', 11, 5);

TABLE escuela_primaria_Temporal;

-- SUBCONSULTAS

SELECT c.nombre
FROM clientes c
INNER JOIN ventas v
  ON v.cliente_id = c.id
WHERE v.precio_unitario > (SELECT AVG(precio) FROM productos);

SELECT *
FROM empleados
WHERE salario > ANY (
  SELECT salario
  FROM empleados e
  INNER JOIN departamentos d
    ON e.departamento_id = d.id
  WHERE d.nombre = 'Ventas'
);

SELECT *
FROM productos
WHERE precio > ALL (
  SELECT precio
  FROM productos
  WHERE nombre LIKE '%Móvil%'
);

-- *
SELECT c.nombre, c.direccion, v.monto_total
FROM clientes c
INNER JOIN ventas v
  ON v.cliente_id = c.id
WHERE monto_total = (
  SELECT MAX(monto_total)
  FROM ventas
);

SELECT d.nombre, e1.nombre, e1.salario
FROM departamentos d
LEFT JOIN empleados e1
  ON e1.departamento_id = d.id
WHERE e1.salario = (
  SELECT MAX(salario)
  FROM empleados e2
  WHERE e2.departamento_id = d.id
);

-- PARTE 2
SELECT *
FROM empleados e1
WHERE e1.salario > (
  SELECT AVG(e2.salario)
  FROM empleados e2
  INNER JOIN departamentos d
    ON e2.departamento_id = d.id
  WHERE d.nombre = 'Contabilidad'
);

SELECT *
FROM productos p1
WHERE p1.precio > ANY(
  SELECT v.precio_unitario
  FROM ventas v
  INNER JOIN clientes c
    ON v.cliente_id = c.id
  WHERE c.nombre = 'Juan Pérez'
);

SELECT *
FROM departamentos d
WHERE d.id = ANY(
  SELECT DISTINCT departamento_id
  FROM empleados
  WHERE edad < 30
);

SELECT e.nombre, e.apellido, e.edad
FROM (
  SELECT empleado_id
  FROM ventas
  GROUP BY empleado_id
  ORDER BY SUM(cantidad) DESC
  LIMIT 3
) AS mas_vendidos
INNER JOIN empleados e
  ON empleado_id = e.id
ORDER BY edad ASC
LIMIT 1;

-- ^
-- SELECT e.nombre, e.apellido, e.edad edad
--   FROM empleados e
--   INNER JOIN ventas v
--     ON v.empleado_id = e.id
--   GROUP BY e.id
--   ORDER BY SUM(cantidad) DESC
--   LIMIT 3;

SELECT DISTINCT c.nombre, e.nombre, v.monto_total
FROM clientes c
INNER JOIN ventas v
  ON v.cliente_id = c.id
INNER JOIN empleados e
  ON v.empleado_id = e.id
WHERE (c.id, v.monto_total) = (
  SELECT cliente_id, MAX(monto_total)
  FROM ventas
  WHERE cliente_id = c.id
  GROUP BY cliente_id
);

