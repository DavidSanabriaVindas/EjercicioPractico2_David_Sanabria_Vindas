/* Se crea la base de datos */
DROP SCHEMA IF EXISTS cine;
DROP USER IF EXISTS 'usuario_prueba'@'%';
CREATE SCHEMA cine;

/* Se crea el usuario para la base de datos */
CREATE USER 'usuario_prueba'@'%' IDENTIFIED BY 'Usuar1o_Clave.';

/* Se asignan los privilegios sobre la base de datos cine al usuario creado */
GRANT ALL PRIVILEGES ON cine.* TO 'usuario_prueba'@'%';
FLUSH PRIVILEGES;

USE cine;

/* Tabla de roles */
CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE -- Cambiado de ENUM a VARCHAR
);

/* Tabla de usuarios */
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255),
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol) -- Relación con la tabla de roles
);

/* Tabla de películas u obras */
/* Tabla de películas u obras */
CREATE TABLE peliculas (
    id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150),
    tipo VARCHAR(50) -- Cambiado de ENUM a VARCHAR
);

/* Tabla de funciones */
CREATE TABLE funciones (
    id_funcion INT AUTO_INCREMENT PRIMARY KEY,
    id_pelicula INT,
    fecha DATE,
    hora TIME,
    sala VARCHAR(50),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula)
);

/* Tabla de reservas */
CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_funcion INT,
    cantidad INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_funcion) REFERENCES funciones(id_funcion)
);

/* Insertar roles de ejemplo */
INSERT INTO roles (nombre) VALUES
('ADMINISTRADOR'),
('USUARIO');

/* Insertar usuarios de ejemplo */
INSERT INTO usuarios (nombre, correo, contrasena, id_rol) VALUES
('Juan Admin', 'juan@cine.com', '123', 1),  -- Rol ADMINISTRADOR
('David Usuario', 'david@cine.com', '123', 2),  -- Rol USUARIO
('Ana López', 'ana@cine.com', 'clave123', 2),  -- Rol USUARIO
('Carlos Pérez', 'carlos@cine.com', 'clave456', 2);  -- Rol USUARIO

/* Insertar películas/obras de ejemplo */
INSERT INTO peliculas (titulo, tipo) VALUES
('El Rey León', 'Obra Musical'),
('Avengers: Endgame', 'Ciencia Ficción'),
('La Bella y la Bestia', 'Obra de Teatro'),
('Spider-Man: No Way Home', 'Superhéroes');

/* Insertar funciones de ejemplo */
INSERT INTO funciones (id_pelicula, fecha, hora, sala) VALUES
(1, '2025-04-20', '18:00:00', 'Sala A'),
(2, '2025-04-21', '20:00:00', 'Sala B'),
(3, '2025-04-22', '17:00:00', 'Sala C'),
(4, '2025-04-23', '21:00:00', 'Sala D');

/* Insertar reservas de ejemplo */
INSERT INTO reservas (id_usuario, id_funcion, cantidad) VALUES
(1, 1, 2),  -- Juan Admin reserva 2 entradas para "El Rey León"
(2, 2, 1),  -- David Usuario reserva 1 entrada para "Avengers: Endgame"
(3, 3, 3),  -- Ana López reserva 3 entradas para "La Bella y la Bestia"
(4, 4, 2);  -- Carlos Pérez reserva 2 entradas para "Spider-Man: No Way Home"