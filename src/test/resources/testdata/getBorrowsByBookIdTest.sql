INSERT INTO editorial (codigo_editorial, nombre_editorial) VALUES(1, 'Norma');
INSERT INTO autor (codigo_autor, apellido, nombre) VALUES(1, 'autor1', 'nombre1');
INSERT INTO usuario (user_identification, apellido_usuario, nombre_usuario) VALUES('1', 'apellido1', 'nombre1');
INSERT INTO usuario (user_identification, apellido_usuario, nombre_usuario) VALUES('2', 'apellido2', 'nombre2');


INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('1', '1', 'libro1', 1);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('2', '2', 'libro2', 1);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('3', '3', 'libro3', 1);

INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(1, 1, '1');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(2, 1, '2');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(3, 1, '3');

INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(1, '2020-01-01', '1', '1');
INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(2, '2020-01-01', '1', '1');
INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(3, '2020-01-01', '2', '1');

