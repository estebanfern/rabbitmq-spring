CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(256) NOT NULL,
    descripcion VARCHAR(256),
    precio BIGINT NOT NULL,
    stock INT DEFAULT 0
);

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(256) NOT NULL,
    correo VARCHAR(256) UNIQUE NOT NULL,
    direccion VARCHAR(256) NOT NULL
);

CREATE TABLE transacciones (
    id SERIAL PRIMARY KEY,
    tipo CHAR(1) CHECK (tipo IN ('C', 'V')),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cliente_id BIGINT REFERENCES clientes(id),
    producto_id SERIAL REFERENCES productos(id),
    cantidad INT NOT NULL,
    precio_total BIGINT
);
