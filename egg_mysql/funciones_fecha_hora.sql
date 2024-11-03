-- Setiembre 24
USE mi_bd;

CREATE TABLE IF NOT EXISTS envios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fecha_envio DATETIME,
  fecha_entrega DATETIME,
  codigo_producto VARCHAR(10)
);

INSERT INTO envios (fecha_envio, fecha_entrega, codigo_producto)
VALUES
  ('2022-01-15 08:00:00', '2022-01-20 12:30:00', 'ABC123'),
  ('2022-02-10 10:15:00', '2022-02-15 14:45:00', 'XYZ789'),
  ('2022-03-05 09:30:00', '2022-03-10 13:20:00', 'PQR456'),
  ('2022-04-20 11:45:00', '2022-04-25 15:10:00', 'LMN001'),
  ('2022-05-12 07:55:00', '2022-05-17 10:25:00', 'DEF777'),
  ('2022-06-08 08:20:00', '2022-06-13 12:40:00', 'GHI888'),
  ('2022-07-03 10:05:00', '2022-07-08 14:15:00', 'JKL999');

SELECT DATE_ADD(fecha_entrega, INTERVAL 5 DAY)
FROM envios
WHERE codigo_producto = 'ABC123';

SELECT ADDTIME(fecha_entrega, '4:30:0')
FROM envios
WHERE codigo_producto = 'XYZ789';

SELECT CONVERT_TZ(fecha_envio, '+00:00', '-03:00')
FROM envios
WHERE codigo_producto = 'PQR456';

SELECT DATEDIFF(fecha_entrega, fecha_envio)
FROM envios
WHERE codigo_producto = 'LMN001';

SELECT DATEDIFF(CURDATE(), fecha_entrega)
FROM envios
WHERE codigo_producto = 'DEF777';

SELECT CURTIME();

SELECT DATE(fecha_envio)
FROM envios
WHERE id = 3;

SELECT DATE_ADD(fecha_entrega, INTERVAL 3 DAY)
FROM envios
WHERE codigo_producto = 'XYZ789';

SELECT DATE_FORMAT(fecha_envio, '%d-%m-%Y')
FROM envios
WHERE id = 6;

SELECT DATE_SUB(fecha_envio, INTERVAL 2 DAY)
FROM envios
WHERE id = 4;

SELECT DATEDIFF(fecha_envio, fecha_entrega)
FROM envios
WHERE codigo_producto = 'PQR456';

SELECT DAY(fecha_envio)
FROM envios
WHERE id = 4;

SELECT DAYNAME(fecha_entrega)
FROM envios
WHERE codigo_producto = 'DEF777';

SELECT DAYOFMONTH(fecha_entrega)
FROM envios
WHERE codigo_producto = 'GHI888';

-- PARTE 2
SELECT PERIOD_ADD(202207, 3);

SELECT PERIOD_DIFF(202203, 202212);

SELECT QUARTER(fecha_entrega)
FROM envios
WHERE codigo_producto = 'PQR456';

SELECT SEC_TO_TIME(3665);

SELECT SECOND(fecha_envio)
FROM envios
WHERE id = 2;

SELECT STR_TO_DATE('2022()08()15','%Y()%m()%d');

SELECT SUBDATE(fecha_entrega, INTERVAL 5 DAY)
FROM envios
WHERE codigo_producto = 'GHI888';

SELECT SUBTIME(fecha_envio, '2:15:00')
FROM envios
WHERE id = 7;

SELECT TIME(fecha_envio)
FROM envios
WHERE id = 1;

SELECT TIME_FORMAT(fecha_envio, '%h:%i:%s')
FROM envios
WHERE id = 2;

SELECT TIME_TO_SEC(fecha_envio)
FROM envios
WHERE id = 2;

SELECT TIMEDIFF(fecha_envio, fecha_entrega)
FROM envios
WHERE id = 4;

SELECT SYSDATE();

SELECT TIMESTAMP(fecha_envio, '12:00:00')
FROM envios;

SELECT TIMESTAMPADD(HOUR, 3, fecha_entrega)
FROM envios
WHERE codigo_producto = 'XYZ789';