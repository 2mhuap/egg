CREATE DATABASE vivero;
USE vivero;

CREATE TABLE pago (
  id_pago INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT,
  forma_pago VARCHAR(40),
  id_transaccion VARCHAR(50),
  fecha_pago DATE,
  total DECIMAL(15,2)
);

CREATE TABLE oficina (
  id_oficina INT AUTO_INCREMENT PRIMARY KEY,
  codigo_oficina VARCHAR(10),
  ciudad VARCHAR(30),
  pais VARCHAR(50),
  region VARCHAR(50),
  codigo_postal VARCHAR(10),
  telefono VARCHAR(20)
);

CREATE TABLE empleado (
  id_empleado INT AUTO_INCREMENT PRIMARY KEY,
  codigo_empleado INT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  extension VARCHAR(10),
  email VARCHAR(100),
  id_oficina INT,
  id_jefe INT,
  puesto VARCHAR(50),
  FOREIGN KEY (id_oficina) REFERENCES oficina(id_oficina),
  FOREIGN KEY (id_jefe) REFERENCES empleado(id_empleado)
);

CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
  codigo_cliente INT,
  nombre_cliente VARCHAR(50),
  nombre_contacto VARCHAR(30),
  apellido_contacto VARCHAR(30),
  telefono VARCHAR(15),
  fax VARCHAR(15),
  ciudad VARCHAR(50),
  region VARCHAR(50),
  pais VARCHAR(50),
  codigo_postal VARCHAR(10),
  id_empleado INT,
  limite_credito DECIMAL(15,2),
  FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
);

ALTER TABLE pago
ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);

CREATE TABLE gama_producto (
  id_gama INT AUTO_INCREMENT PRIMARY KEY,
  gama VARCHAR(50),
  descripcion_texto TEXT,
  descripcion_html TEXT,
  imagen VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS producto (
  id_producto INT AUTO_INCREMENT PRIMARY KEY,
  codigo_producto VARCHAR(15),
  nombre VARCHAR(70),
  id_gama INT,
  dimensiones VARCHAR(25),
  proveedor VARCHAR(50),
  descripcion TEXT,
  cantidad_en_stock SMALLINT,
  precio_venta DECIMAL(15,2),
  precio_proveedor DECIMAL(15,2),
  FOREIGN KEY (id_gama) REFERENCES gama_producto(id_gama)
);

CREATE TABLE IF NOT EXISTS pedido (
  id_pedido INT AUTO_INCREMENT PRIMARY KEY,
  codigo_pedido INT,
  fecha_pedido DATE,
  fecha_esperada DATE,
  fecha_entrega DATE,
  estado VARCHAR(15),
  comentarios TEXT,
  id_cliente INT,
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE IF NOT EXISTS detalle_pedido (
  id_detalle_pedido INT AUTO_INCREMENT PRIMARY KEY,
  id_pedido INT,
  id_producto INT,
  cantidad INT,
  precio_unidad DECIMAL(15,2),
  numero_linea SMALLINT,
  FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);