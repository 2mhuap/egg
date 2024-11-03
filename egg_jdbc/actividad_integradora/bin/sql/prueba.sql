USE estancias_exterior;

SELECT *
FROM casas
WHERE fecha_desde = '2020-08-01';

SELECT *
FROM casas
WHERE fecha_hasta > DATE_ADD(fecha_desde, INTERVAL 40 DAY);

SELECT *
FROM casas
WHERE ('2020-08-16' BETWEEN fecha_desde AND fecha_hasta) AND (fecha_hasta > DATE_ADD('2020-08-16', INTERVAL 20 DAY));

SELECT DISTINCT pais
FROM casas;