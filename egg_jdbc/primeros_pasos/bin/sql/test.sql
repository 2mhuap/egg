USE vivero;
SHOW TABLES;

TABLE cliente;
DESCRIBE cliente;

-- buscarClientes
SELECT nombre_contacto, apellido_contacto, telefono
FROM cliente;

-- buscarClientePorCodigo
SELECT nombre_contacto, apellido_contacto, telefono
FROM cliente
WHERE codigo_cliente = 2;

-- buscarClientesPorEmpleado
SELECT nombre_contacto, apellido_contacto, telefono
FROM cliente
WHERE id_empleado = 7;

TABLE producto;
DESCRIBE producto;

-- getProductosParaReponer
SELECT codigo_producto, nombre, cantidad_en_stock
FROM producto
WHERE cantidad_en_stock < 20;

TABLE gama_producto;
DESCRIBE gama_producto;

-- getProductosGama
SELECT codigo_producto, nombre, g.id_gama, gama
FROM gama_producto g
INNER JOIN producto p
  ON g.id_gama = p.id_gama
WHERE gama = "Herramientas";

TABLE pedido;
DESCRIBE pedido;

-- getPedidosPorCliente
SELECT codigo_pedido, fecha_pedido, estado
FROM pedido
WHERE id_cliente = 3;

-- getPedidosPorEstado
SELECT codigo_pedido, fecha_pedido, estado
FROM pedido
WHERE estado = 'Pendiente';

-- EJERCICIO COMPLEMENTARIO
DESCRIBE detalle_pedido;
-- getPedidosNoComprados
SELECT pr.nombre
FROM producto pr
WHERE 0 = (
  SELECT SUM(dp.id_producto = pr.id_producto)
  FROM detalle_pedido dp
);

-- solucion oficial
SELECT *
FROM producto pr
LEFT JOIN detalle_pedido dp
  ON pr.id_producto = dp.id_producto
WHERE dp.id_producto IS NULL;

-- SELECT id_producto
-- FROM producto
-- WHERE nombre = 'Rosal copa ';
-- -- 39

-- SELECT *
-- FROM detalle_pedido
-- WHERE id_producto = 39;