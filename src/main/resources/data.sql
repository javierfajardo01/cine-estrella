-- Insertar Películas
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES ('Pulp Fiction', 'Quentin Tarantino', 154, 'DRAMA');
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES ('The Dark Knight', 'Christopher Nolan', 152, 'ACCION');
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES ('Forrest Gump', 'Robert Zemeckis', 142, 'DRAMA');
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES ('The Lion King', 'Roger Allers', 88, 'ANIMACION');
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES ('The Shining', 'Stanley Kubrick', 146, 'TERROR');

-- Insertar Salas
INSERT INTO salas (numero, capacidad_maxima, tiene3d) VALUES (1, 100, true);
INSERT INTO salas (numero, capacidad_maxima, tiene3d) VALUES (2, 80, false);
INSERT INTO salas (numero, capacidad_maxima, tiene3d) VALUES (3, 120, true);

-- Insertar Sesiones
-- Sesiones para Pulp Fiction (pelicula_id = 1)
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES ('2024-08-15 18:00:00', 8.50, 1, 1);
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES ('2024-08-15 21:00:00', 9.00, 1, 1);

-- Sesiones para The Dark Knight (pelicula_id = 2)
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES ('2024-08-15 17:30:00', 9.50, 2, 2);
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES ('2024-08-15 20:30:00', 10.00, 2, 3);

-- Sesiones para The Lion King (pelicula_id = 4)
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES ('2024-08-16 16:00:00', 7.50, 4, 2);

-- Insertar Entradas
-- Entradas para la primera sesión de Pulp Fiction (sesion_id = 1)
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES (10, 'Juan Perez', 1);
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES (11, 'Ana Lopez', 1);

-- Entradas para la primera sesión de The Dark Knight (sesion_id = 3)
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES (5, 'Carlos Garcia', 3);

-- Entradas para la sesión de The Lion King (sesion_id = 5)
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES (15, 'Maria Rodriguez', 5);
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES (16, 'David Martinez', 5);
