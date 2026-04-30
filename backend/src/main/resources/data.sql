INSERT INTO restaurantes (correo, clave, pais, cp, ciudad, direccion, rol) VALUES
('sevilla@empresa.com',    '$2a$10$Z1DqIU/K9fWQ4dyZ.lDQMe1ECWuMCN6I4Jy/A7hV08dIQmVP8.5bW', 'España', 41001, 'Sevilla',   'Calle Tetuan 1',           'ROLE_USER'),
('barcelona1@empresa.com', '$2a$10$Z1DqIU/K9fWQ4dyZ.lDQMe1ECWuMCN6I4Jy/A7hV08dIQmVP8.5bW', 'España',  8001, 'Barcelona', 'La Rambla 50',             'ROLE_USER'),
('valencia1@empresa.com',  '$2a$10$Z1DqIU/K9fWQ4dyZ.lDQMe1ECWuMCN6I4Jy/A7hV08dIQmVP8.5bW', 'España', 46001, 'Valencia',  'Plaza del Ayuntamiento 3', 'ROLE_USER');

INSERT INTO categorias (nombre, descripcion) VALUES
('Bebidas con', 'Bebidas con alcohol'),
('Bebidas sin', 'Bebidas sin alcohol'),
('Comida', 'Alimentos y platos preparados'),
('Limpieza', 'Productos de limpieza e higiene'),
('Materiales', 'Material de oficina y utensilios');

--Bebidas con alcohol (categoria 1)
INSERT INTO productos (nombre, descripcion, peso, stock, categoria) VALUES
('Cerveza Alhambra tercio', '24 botellas de 33cl', 10, 15, 1),
('Vino tinto Rioja 0.75', '6 botellas de 0.75', 5.5, 10, 1),
('Cerveza Mahou lata', '24 latas de 33cl', 9, 20, 1);

--Bebidas sin alcohol (categoria 2)
INSERT INTO productos (nombre, descripcion, peso, stock, categoria) VALUES
('Agua mineral 1.5L', '6 botellas de 1.5L', 9, 50, 2),
('Coca-Cola lata', '24 latas de 33cl', 8.5, 30, 2),
('Zumo naranja 1L', '12 bricks de 1L', 12, 25, 2);

--Comida (categoria 3)
INSERT INTO productos (nombre, descripcion, peso, stock, categoria) VALUES
('Sal', '20 paquetes de 1kg cada uno', 20, 40, 3),
('Aceite oliva 5L', 'Garrafa de aceite de oliva virgen extra', 5, 15, 3),
('Arroz 1kg', '10 paquetes de arroz de 1kg', 10, 35, 3),
('Harina 1kg', '10 paquetes de harina de 1kg', 10, 30, 3);

--Limpieza 1 (categoria 4)
INSERT INTO productos (nombre, descripcion, peso, stock, categoria) VALUES
('Lejía 5L', 'Garrafa de lejía', 5, 20, 4),
('Lavavajillas 1L', 'Botella de lavavajillas concentrado', 1, 25, 4);

--Limpieza 2 (categoria 5)
INSERT INTO productos (nombre, descripcion, peso, stock, categoria) VALUES
('Servilletas', '20 paquetes de 100 unidades', 5, 45, 5),
('Rollo cocina', '12 rollos de papel de cocina', 3, 30, 5);