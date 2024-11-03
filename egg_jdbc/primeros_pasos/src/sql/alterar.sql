USE vivero;
DESCRIBE detalle_pedido;
SHOW CREATE TABLE detalle_pedido;

ALTER TABLE detalle_pedido DROP FOREIGN KEY detalle_pedido_ibfk_2;

ALTER TABLE detalle_pedido
ADD CONSTRAINT detalle_pedido_ibfk_2
FOREIGN KEY (id_producto)
REFERENCES producto (id_producto)
ON DELETE CASCADE;

-- CREATE TABLE `detalle_pedido` (
--   `id_detalle_pedido` int NOT NULL AUTO_INCREMENT,
--   `id_pedido` int DEFAULT NULL,
--   `id_producto` int DEFAULT NULL,
--   `cantidad` int DEFAULT NULL,
--   `precio_unidad` decimal(15,2) DEFAULT NULL,
--   `numero_linea` smallint DEFAULT NULL,
--   PRIMARY KEY (`id_detalle_pedido`),
--   KEY `id_pedido` (`id_pedido`),
--   KEY `id_producto` (`id_producto`),
--   CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
--   CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- CREATE TABLE `detalle_pedido` (
--   `id_detalle_pedido` int NOT NULL AUTO_INCREMENT,
--   `id_pedido` int DEFAULT NULL,
--   `id_producto` int DEFAULT NULL,
--   `cantidad` int DEFAULT NULL,
--   `precio_unidad` decimal(15,2) DEFAULT NULL,
--   `numero_linea` smallint DEFAULT NULL,
--   PRIMARY KEY (`id_detalle_pedido`),
--   KEY `id_pedido` (`id_pedido`),
--   KEY `detalle_pedido_ibfk_2` (`id_producto`),
--   CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
--   CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE
-- ) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci