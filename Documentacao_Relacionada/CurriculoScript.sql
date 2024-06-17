CREATE TABLE usuario();
CREATE TABLE curriculo();
CREATE TABLE endereco();
CREATE TABLE bairro();
CREATE TABLE cidade();
CREATE TABLE estado();
CREATE TABLE pais();
CREATE TABLE formacao();
CREATE TABLE experiencia_profissional();

ALTER TABLE usuario
	ADD COLUMN id_usuario SERIAL PRIMARY KEY, 
	ADD COLUMN nome_usuario VARCHAR(255),
	ADD COLUMN email_usuario VARCHAR(255),
	ADD COLUMN senha_usuario VARCHAR(255);

ALTER TABLE curriculo
	ADD COLUMN id_curriculo SERIAL PRIMARY KEY,
	ADD COLUMN url_foto_pessoal VARCHAR(255),
	ADD COLUMN cpf INT UNIQUE,
	ADD COLUMN data_nascimento DATE,
	ADD COLUMN id_usuario INT,
	ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);

ALTER TABLE endereco
	ADD COLUMN id_endereco SERIAL PRIMARY KEY,
	ADD COLUMN rua VARCHAR(255),
	ADD COLUMN id_bairro INT,
	ADD CONSTRAINT fk_id_bairro FOREIGN KEY (id_bairro) REFERENCES bairro (id_bairro),
	ADD COLUMN id_cidade INT,
	ADD CONSTRAINT fk_id_cidade FOREIGN KEY (id_cidade) REFERENCES cidade (id_cidade),
	ADD COLUMN id_estado INT,
	ADD CONSTRAINT fk_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id_estado),
	ADD COLUMN id_pais INT,
	ADD CONSTRAINT fk_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id_pais);

ALTER TABLE bairro
	ADD COLUMN id_bairro SERIAL PRIMARY KEY,
	ADD COLUMN nome_bairro VARCHAR(255);

ALTER TABLE cidade
	ADD COLUMN id_cidade SERIAL PRIMARY KEY,
	ADD COLUMN nome_cidade VARCHAR(255);

ALTER TABLE estado
	ADD COLUMN id_estado SERIAL PRIMARY KEY,
	ADD COLUMN nome_estado VARCHAR(255);

ALTER TABLE pais
	ADD COLUMN id_pais SERIAL PRIMARY KEY,
	ADD COLUMN nome_pais VARCHAR(255);

ALTER TABLE formacao
	ADD COLUMN id_formacao SERIAL PRIMARY KEY,
	ADD COLUMN curso VARCHAR(255),
	ADD COLUMN status_formacao BOOLEAN,
	ADD COLUMN id_curriculo INT,
	ADD CONSTRAINT fk_id_curriculo FOREIGN KEY (id_curriculo) REFERENCES curriculo (id_curriculo);

ALTER TABLE experiencia_profissional
	ADD COLUMN id_exp_profissional SERIAL PRIMARY KEY,
	ADD COLUMN nome_empresa VARCHAR(255),
	ADD COLUMN data_inicio DATE,
	ADD COLUMN data_termino DATE,
	ADD COLUMN status_exp_profissional BOOLEAN,
	ADD COLUMN id_curriculo INT,
	ADD CONSTRAINT fk_id_curriculo FOREIGN KEY (id_curriculo) REFERENCES curriculo (id_curriculo);

SELECT * FROM experiencia_profissional;
