-- Setiembre 25
USE mi_bd;

CREATE TABLE IF NOT EXISTS triangulos_rectangulos (
  longitud_lado_adyacente INT,
  longitud_lado_opuesto INT
);

TABLE triangulos_rectangulos;

-- X2
INSERT INTO triangulos_rectangulos
VALUES
(FLOOR(1 + RAND() * (100)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (100)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (100)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (100)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (100)), FLOOR(1 + RAND() * (100)));

CREATE OR REPLACE VIEW vista_pitagoras AS
SELECT *,
  SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) AS 'hipotenusa'
FROM triangulos_rectangulos;

TABLE vista_pitagoras;

CREATE OR REPLACE VIEW vista_pitagoras AS
SELECT *,
  SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) hipotenusa,
  ATAN(longitud_lado_adyacente / longitud_lado_opuesto) 'α_radianes',
  DEGREES(ATAN(longitud_lado_adyacente / longitud_lado_opuesto)) 'α_grados'
FROM triangulos_rectangulos;

CREATE OR REPLACE VIEW vista_pitagoras AS
SELECT *,
  SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) hipotenusa,
  ATAN(longitud_lado_adyacente / longitud_lado_opuesto) 'α_radianes',
  DEGREES(ATAN(longitud_lado_adyacente / longitud_lado_opuesto)) 'α_grados',
  ATAN(longitud_lado_opuesto / longitud_lado_adyacente) 'β_radianes',
  DEGREES(ATAN(longitud_lado_opuesto / longitud_lado_adyacente)) 'β_grados'
FROM triangulos_rectangulos;

CREATE OR REPLACE VIEW vista_pitagoras AS
SELECT *,
  RADIANS(180 - α_grados - β_grados) γ_radianes,
  (180 - α_grados - β_grados) γ_grados
FROM (
  SELECT *,
    SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) hipotenusa,
    ATAN(longitud_lado_adyacente / longitud_lado_opuesto) 'α_radianes',
    DEGREES(ATAN(longitud_lado_adyacente / longitud_lado_opuesto)) 'α_grados',
    ATAN(longitud_lado_opuesto / longitud_lado_adyacente) 'β_radianes',
    DEGREES(ATAN(longitud_lado_opuesto / longitud_lado_adyacente)) 'β_grados'
  FROM triangulos_rectangulos
) v;

-- 

CREATE TABLE IF NOT EXISTS triangulos_rectangulos_2 (
  angulo_alfa INT,
  hipotenusa INT
);

TABLE triangulos_rectangulos_2;

-- X2
INSERT INTO triangulos_rectangulos_2
VALUES
(FLOOR(1 + RAND() * (89)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (89)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (89)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (89)), FLOOR(1 + RAND() * (100))),
(FLOOR(1 + RAND() * (89)), FLOOR(1 + RAND() * (100)));

TABLE vista_pitagoras_2;

CREATE OR REPLACE VIEW vista_pitagoras_2 AS
SELECT *,
  (SIN(RADIANS(angulo_alfa)) * hipotenusa) lado_adyacente
FROM triangulos_rectangulos_2;

CREATE OR REPLACE VIEW vista_pitagoras_2 AS
SELECT *,
  (SIN(RADIANS(angulo_alfa)) * hipotenusa) lado_adyacente,
  (COS(RADIANS(angulo_alfa)) * hipotenusa) lado_opuesto
FROM triangulos_rectangulos_2;

CREATE OR REPLACE VIEW vista_pitagoras_2 AS
SELECT *,
  DEGREES(ATAN(lado_opuesto / lado_adyacente)) angulo_beta
FROM (
  SELECT
    *,
    (SIN(RADIANS(angulo_alfa)) * hipotenusa) lado_adyacente,
    (COS(RADIANS(angulo_alfa)) * hipotenusa) lado_opuesto
  FROM triangulos_rectangulos_2
) v;

CREATE OR REPLACE VIEW vista_pitagoras_2 AS
SELECT *,
  180 - angulo_beta - angulo_alfa angulo_gamma
FROM (
  SELECT *,
    DEGREES(ATAN(lado_opuesto / lado_adyacente)) angulo_beta
  FROM (
    SELECT *,
      (SIN(RADIANS(angulo_alfa)) * hipotenusa) lado_adyacente,
      (COS(RADIANS(angulo_alfa)) * hipotenusa) lado_opuesto
    FROM triangulos_rectangulos_2
  ) t
) v;

CREATE OR REPLACE VIEW vista_pitagoras_2 AS
SELECT *,
  ROUND(180 - angulo_beta - angulo_alfa, 2) angulo_gamma_2
FROM (
  SELECT *,
    ROUND(DEGREES(ATAN(lado_opuesto / lado_adyacente)), 2) angulo_beta
  FROM (
    SELECT *,
      ROUND(SIN(RADIANS(angulo_alfa)) * hipotenusa) lado_adyacente,
      ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa) lado_opuesto
    FROM triangulos_rectangulos_2
  ) t
) v;

CREATE TABLE IF NOT EXISTS mensajes (
  datos VARCHAR(100),
  valor_crc BIGINT
);

-- instrucciones decían INT
-- ALTER TABLE mensajes MODIFY valor_crc BIGINT;

INSERT INTO mensajes
VALUES
('Hola, ¿como estas? Espero que tengas un buen dia.', 3221685809),
('Ayer fui al cine a ver una película genial.', 951196167),
('Estoy emocionado por el próximo fin de semana.', 3275166159),
('Mi reunión se pospuso para el martes que viene.', 169741145),
('He estado trabajando en un proyecto importante.', 6480112535),
('Esta receta de pastel de manzana es deliciosa.', 2524836786),
('Planeo hacer un viaje a la playa este verano.', 5107635050),
('Mi gato se divierte jugando con su pelota.', 3578632817),
('Hoy es un día soleado y agradable.', 3675102258),
('El libro que estoy leyendo es muy interesante.', 854938277);

TABLE mensajes;