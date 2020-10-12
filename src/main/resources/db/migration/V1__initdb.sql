CREATE TABLE autor (
	codigo_autor int8 NOT NULL,
	apellido varchar(255) NULL,
	nombre varchar(255) NULL,
	CONSTRAINT autor_pkey PRIMARY KEY (codigo_autor)
);

CREATE TABLE editorial (
	codigo_editorial int8 NOT NULL,
	nombre_editorial varchar(255) NULL,
	CONSTRAINT editorial_pkey PRIMARY KEY (codigo_editorial)
);

CREATE TABLE usuario (
	user_identification varchar(255) NOT NULL,
	apellido_usuario varchar(255) NULL,
	nombre_usuario varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (user_identification)
);

CREATE TABLE libro (
	codigo_libro varchar(255) NOT NULL,
	isbn_libro varchar(255) NULL,
	nombre_libro varchar(255) NULL,
	id_editorial int8 NULL,
	CONSTRAINT libro_pkey PRIMARY KEY (codigo_libro),
	CONSTRAINT fk7901riu71fmob1ocuw98n988m FOREIGN KEY (id_editorial) REFERENCES editorial(codigo_editorial)
);

CREATE TABLE libro_autor (
	id int8 NOT NULL,
	id_autor int8 NULL,
	id_libro varchar(255) NULL,
	CONSTRAINT libro_autor_pkey PRIMARY KEY (id),
	CONSTRAINT fkjayuqybgpxt8vuasqdueh9hj1 FOREIGN KEY (id_autor) REFERENCES autor(codigo_autor),
	CONSTRAINT fknmunvv424dlmlolmddpj7edjd FOREIGN KEY (id_libro) REFERENCES libro(codigo_libro)
);

CREATE TABLE prestamo (
	id int8 auto_increment NOT NULL,
	fecha_prestamo timestamp NULL,
	id_libro varchar(255) NULL,
	id_usuario varchar(255) NULL,
	CONSTRAINT prestamo_pkey PRIMARY KEY (id),
	CONSTRAINT fk5avf7s8x7uj7osdvn220wm79s FOREIGN KEY (id_usuario) REFERENCES usuario(user_identification),
	CONSTRAINT fkqon25d8x23eac9lbngoqthf1i FOREIGN KEY (id_libro) REFERENCES libro(codigo_libro)
);