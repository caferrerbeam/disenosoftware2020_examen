INSERT INTO editorial (codigo_editorial, nombre_editorial) VALUES(1, 'Norma');
INSERT INTO autor (codigo_autor, apellido, nombre) VALUES(1, 'autor1', 'nombre1');
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('1', '1', 'libro1', 1);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('2', '2', 'libro2', 1);
INSERT INTO libro (codigo_libro, isbn_libro, nombre_libro, id_editorial) VALUES('3', '3', 'libro3', 1);

INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(1, 1, '1');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(2, 1, '2');
INSERT INTO libro_autor (id, id_autor, id_libro) VALUES(3, 1, '3');

