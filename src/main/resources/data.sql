-- Insertar Películas
INSERT INTO peliculas (titulo, director, duracion, clasificacion) VALUES
('Pulp Fiction', 'Quentin Tarantino', 154, 'DRAMA'),
('The Dark Knight', 'Christopher Nolan', 152, 'ACCION'),
('Forrest Gump', 'Robert Zemeckis', 142, 'DRAMA'),
('The Lion King', 'Roger Allers', 88, 'ANIMACION'),
('The Shining', 'Stanley Kubrick', 146, 'TERROR');

-- Insertar Salas
INSERT INTO salas (numero, capacidad_maxima, tiene3d) VALUES
(1, 100, true),
(2, 80, false),
(3, 120, true);

-- Insertar Sesiones (asumiendo que las películas y salas ya existen)
-- Sesiones para Pulp Fiction (pelicula_id = 1)
INSERT INTO sesiones (fecha_hora, precio, pelicula_id, sala_id) VALUES
('2024-08-15 18:00:00', 8.50, 1, 1),
('2024-08-15 21:00:00', 9.00, 1, 1),
-- Sesiones para The Dark Knight (pelicula_id = 2)
('2024-08-15 17:30:00', 9.50, 2, 2),
('2024-08-15 20:30:00', 10.00, 2, 3),
-- Sesiones para The Lion King (pelicula_id = 4)
('2024-08-16 16:00:00', 7.50, 4, 2);

-- Insertar Entradas (asumiendo que las sesiones ya existen)
-- Entradas para la primera sesión de Pulp Fiction (sesion_id = 1)
INSERT INTO entradas (asiento, nombre_cliente, sesion_id) VALUES
(10, 'Juan Perez', 1),
(11, 'Ana Lopez', 1),
-- Entradas para la primera sesión de The Dark Knight (sesion_id = 3)
(5, 'Carlos Garcia', 3),
-- Entradas para la sesión de The Lion King (sesion_id = 5)
(15, 'Maria Rodriguez', 5),
(16, 'David Martinez', 5);
