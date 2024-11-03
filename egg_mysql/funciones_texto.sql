-- Setiembre 23
USE mi_bd;

CREATE TABLE IF NOT EXISTS estudiantes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  edad INT,
  promedio FLOAT
);

INSERT INTO estudiantes (nombre, apellido, edad, promedio)
VALUES
  ('Juan', 'Pérez', 22, 85.5),
  ('María', 'Gómez', 21, 90),
  ('Luis', 'Rodríguez', 20, 88.5),
  ('Ana', 'Martínez', 23, 92),
  ('Carlos', 'López', 22, 86.5);

-- Ejercicios

SELECT LENGTH(nombre)
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

SELECT CONCAT(nombre, ' ', apellido)
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

SELECT LOCATE('e', apellido)
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

SELECT INSERT(nombre, 3, 6, 'García')
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

SELECT LOWER(nombre)
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

SELECT UPPER(apellido)
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

SELECT LEFT(nombre, 4)
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

SELECT RIGHT(apellido, 3)
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

SELECT LOCATE('o', nombre)
FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';

SELECT LOCATE('a', nombre)
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

SELECT REPLACE(nombre, 'a', 'x')
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

SELECT MID(nombre, 2, 3)
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

SELECT GROUP_CONCAT(nombre SEPARATOR '-')
FROM estudiantes;

SELECT GROUP_CONCAT(CONCAT(nombre, apellido) SEPARATOR '|')
FROM estudiantes;

SELECT LTRIM("    … usé muchos espacios    ");

SELECT RTRIM("    … usé muchos espacios    ");

SELECT QUOTE(LTRIM("    … usé muchos espacios    ")),
  QUOTE(RTRIM("    … usé muchos espacios    "));

-- PARTE 2

SELECT REPEAT(CONCAT(nombre, apellido), 3)
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

SELECT REVERSE(nombre)
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

SELECT QUOTE(SPACE(8));

SELECT SUBSTRING_INDEX(nombre,'a', 2)
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

SELECT GROUP_CONCAT(edad ORDER BY edad DESC SEPARATOR ',')
FROM estudiantes;

SELECT REPLACE(nombre, 'a', '')
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

SELECT RPAD(promedio, 10, '*')
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

SELECT FORMAT(promedio, 2, 'es_AR')
FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';