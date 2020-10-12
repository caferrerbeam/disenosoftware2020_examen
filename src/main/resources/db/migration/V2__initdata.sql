INSERT INTO editorial (codigo_editorial, nombre_editorial) VALUES(10, 'Norma');
INSERT INTO autor (codigo_autor, apellido, nombre) VALUES(10, 'autor1', 'nombre1');
INSERT INTO usuario (user_identification, apellido_usuario, nombre_usuario) VALUES('10', 'apellido1', 'nombre1');
INSERT INTO usuario (user_identification, apellido_usuario, nombre_usuario) VALUES('20', 'apellido2', 'nombre2');


INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('10', '10', 'libro10', 10);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('20', '20', 'libro20', 10);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('30', '30', 'libro30', 10);

INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(10, 10, '10');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(20, 10, '20');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(30, 10, '30');

INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(10, '2020-01-01', '10', '10');
INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(20, '2020-01-01', '20', '10');
INSERT INTO prestamo (id, fecha_prestamo, id_libro, id_usuario) VALUES(30, '2020-01-01', '30', '20');

