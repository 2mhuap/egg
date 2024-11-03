-- Setiembre 11 2024
USE mi_bd;

SELECT * FROM empleados;
DESCRIBE empleados;

-- MODIFICAR
ALTER TABLE empleados MODIFY edad INT NOT NULL;
ALTER TABLE empleados MODIFY salario DECIMAL(10,2) DEFAULT 0;

-- AGREGAR
ALTER TABLE empleados ADD departamento VARCHAR(50);
ALTER TABLE empleados ADD correo_electronico VARCHAR(100);

-- ELIMINAR
ALTER TABLE empleados DROP fecha_contratacion;

ALTER TABLE empleados ADD fecha_contratacion DATE DEFAULT (CURRENT_DATE);

-- CREAR TABLA DEPARTAMENTOS
CREATE TABLE IF NOT EXISTS departamentos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50)
);

-- AGREGANDO FOREIGN KEY
ALTER TABLE empleados ADD departamento_id INT;

ALTER TABLE empleados
ADD FOREIGN KEY (departamento_id) REFERENCES departamentos(id);

ALTER TABLE empleados DROP departamento;
