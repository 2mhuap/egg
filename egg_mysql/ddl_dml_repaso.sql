-- Setiembre 11 2024

CREATE TABLE IF NOT EXISTS clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  direccion VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  precio DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS ventas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  producto_id INT,
  cliente_id INT,
  cantidad INT,
  precio_unitario DECIMAL(10,2),
  monto_total DECIMAL(10,2),
  empleado_id INT
);

ALTER TABLE ventas
ADD FOREIGN KEY (producto_id) REFERENCES productos(id);
ALTER TABLE ventas
ADD FOREIGN KEY (cliente_id) REFERENCES clientes(id);
ALTER TABLE ventas
ADD FOREIGN KEY (empleado_id) REFERENCES empleados(id);

SELECT * FROM productos;
SELECT * FROM clientes;
SELECT * FROM empleados;
SELECT * FROM ventas;

INSERT INTO clientes (nombre, direccion)
VALUES ('Juan Pérez', 'Libertad 3215, Mar del Plata');
INSERT INTO productos (nombre, precio)
VALUES ('Laptop', 1200);

ALTER TABLE ventas
MODIFY monto_total DECIMAL(10,2) GENERATED ALWAYS AS (precio_unitario * cantidad) STORED;

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 1, 2, 1200, 1);