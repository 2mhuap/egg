-- USE mi_bd;
-- TABLE clientes;

-- SELECT SUM(id > 6)
-- FROM clientes;

USE nba;

-- Mostrar el nombre y peso de los diez jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por peso.
SELECT nombre, peso
FROM jugadores
WHERE posicion = 'C' AND peso > 200
ORDER BY peso
LIMIT 10;

-- Mostrar el nombre de los equipos del este (East).
SELECT nombre
FROM equipos
WHERE conferencia = 'East';

-- Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT *
FROM equipos
WHERE LOWER(ciudad) LIKE 'c%'
ORDER BY nombre;

-- Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT puntos_por_partido
FROM estadisticas e
INNER JOIN jugadores j
  ON e.jugador = j.codigo
WHERE j.nombre = 'Pau Gasol' AND temporada = '04/05';

-- Mostrar los diez jugadores con más puntos en toda su carrera con un redondeo de dos decimales.
SELECT nombre, ROUND(SUM(puntos_por_partido), 2) puntos_carrera
FROM jugadores j
INNER JOIN estadisticas e
  ON e.jugador = j.codigo
GROUP BY e.jugador
ORDER BY puntos_carrera DESC
LIMIT 10;

-- Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT e.nombre, e.conferencia, e.division
FROM equipos e
INNER JOIN jugadores j
  ON j.nombre_equipo = e.nombre
WHERE j.altura = (
  SELECT MAX(altura)
  FROM jugadores
);

-- Mostrar los 10 partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
SELECT equipo_local, equipo_visitante,
  ABS(puntos_local - puntos_visitante) diferencia
FROM partidos
ORDER BY diferencia DESC
LIMIT 10;

-- Muestra el nombre del equipo con la mayor diferencia de puntos totales de la temporada temporada "00/01".
-- SELECT MAX(ABS(puntos_local - puntos_visitante))
-- FROM equipos e
-- INNER JOIN partidos p
--   ON 

-- Encuentra el nombre de los diez equipos que mejor porcentaje de victorias tengan en la temporada "98/99". El número de porcentaje debe estar escrito del 1 al 100 con hasta dos decimales y acompañado por el símbolo “%”.

-- equipos, partidos (porcentaje_victorias, temporada)
-- ORDER BY porcentaje_victorias DESC
-- LIMIT 10
-- CONCAT(ROUND(porcentaje, 2), '%')
-- COUNT(ganador) / COUNT(equipo_local)

SELECT nombre, COUNT(codigo) total
FROM equipos e
INNER JOIN partidos p
  ON e.nombre = p.equipo_local OR e.nombre = p.equipo_visitante
WHERE temporada = '98/99'
GROUP BY nombre;
-- total = 116

-- SELECT COUNT(codigo)
-- FROM partidos
-- WHERE (equipo_local = 'Lakers' OR equipo_visitante = 'Lakers') AND temporada = '98/99';

-- local ganador
CREATE OR REPLACE VIEW victorias_local AS
SELECT nombre, SUM(puntos_local > puntos_visitante) victorias
FROM equipos e
INNER JOIN partidos p
  ON e.nombre = p.equipo_local
WHERE temporada = '98/99'
GROUP BY nombre;

-- visitante ganador
CREATE OR REPLACE VIEW victorias_visitante AS
SELECT nombre, SUM(puntos_local < puntos_visitante) victorias
FROM equipos e
INNER JOIN partidos p
  ON e.nombre = p.equipo_visitante
WHERE temporada = '98/99'
GROUP BY nombre;

-- victorias total
SELECT vl.nombre nombre, vv.victorias, vl.victorias
FROM victorias_local vl
INNER JOIN victorias_visitante vv
  ON vl.nombre = vv.nombre;

SELECT nombre, CONCAT(ROUND((victorias / 116) * 100, 2), '%') porcentaje_victorias
FROM (
  SELECT vl.nombre nombre, vv.victorias + vl.victorias victorias
  FROM victorias_local vl
  INNER JOIN victorias_visitante vv
    ON vl.nombre = vv.nombre
) victorias_total
ORDER BY porcentaje_victorias DESC
LIMIT 10;


-- Calcula el promedio de puntos por partido de los jugadores que son pivotes ('C') y tienen más de 7 pies de altura, y redondea el resultado a dos decimales.

-- estadisticas (puntos_por_partido), jugadores (altura)
SELECT j.nombre jugador, ROUND(AVG(puntos_por_partido), 2) promedio_puntos
FROM jugadores j
INNER JOIN estadisticas e
  ON j.codigo = e.jugador
WHERE j.posicion = 'C' AND j.altura LIKE '7%' AND j.altura != '7-0'
GROUP BY j.nombre;

-- Muestra el nombre del jugador que ha registrado el mayor número de asistencias en un solo partido.
SELECT j.nombre
FROM jugadores j
INNER JOIN estadisticas e
  ON e.jugador = j.codigo
WHERE e.asistencias_por_partido = (
  SELECT MAX(asistencias_por_partido)
  FROM estadisticas
);

-- Encuentra el total de partidos en los que el equipo local anotó más de 100 puntos y el equipo visitante anotó menos de 90 puntos.

SELECT COUNT(*)
FROM partidos
WHERE puntos_local > 100 AND puntos_visitante < 90;

-- Calcula la diferencia de puntos promedio en todos los partidos de la temporada “00/01” y redondea el resultado a dos decimales.

SELECT ROUND(AVG(ABS(puntos_local - puntos_visitante)), 2) diferencia_puntos_promedio
FROM partidos
WHERE temporada = '00/01';

-- Encuentra el nombre del equipo que ha tenido al menos un jugador que ha promediado más de 10 rebotes por partido en la temporada “97/98”.
SELECT DISTINCT j.nombre_equipo
FROM (
  SELECT jugador
  FROM estadisticas
  WHERE temporada = '97/98'
  GROUP BY jugador
  HAVING AVG(rebotes_por_partido) > 10
) r
INNER JOIN jugadores j
  ON r.jugador = j.codigo;
