--Script de Inserção de Dados'
INSERT INTO pais (id_pais, nome_pais) VALUES
  (1, 'Brasil'),
  (2, 'Estados Unidos');

INSERT INTO estado (nome_estado, fk_id_pais) VALUES
    ('Bahia', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil')),
    ('São Paulo', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil')),
    ('Rio de Janeiro', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil')),
    ('Minas Gerais', (SELECT id_pais FROM pais WHERE nome_pais = 'Brasil')),
    ('California', (SELECT id_pais FROM pais WHERE nome_pais = 'Estados Unidos')),
    ('New York', (SELECT id_pais FROM pais WHERE nome_pais = 'Estados Unidos')),
    ('Texas', (SELECT id_pais FROM pais WHERE nome_pais = 'Estados Unidos')),
    ('Florida', (SELECT id_pais FROM pais WHERE nome_pais = 'Estados Unidos'));

INSERT INTO cidade (nome_cidade, fk_id_estado) VALUES
    ('Salvador', (SELECT id_estado FROM estado WHERE nome_estado = 'Bahia')),
    ('Feira de Santana', (SELECT id_estado FROM estado WHERE nome_estado = 'Bahia')),
    ('Vitória da Conquista', (SELECT id_estado FROM estado WHERE nome_estado = 'Bahia')),
    ('Itabuna', (SELECT id_estado FROM estado WHERE nome_estado = 'Bahia')),
    ('São Paulo', (SELECT id_estado FROM estado WHERE nome_estado = 'São Paulo')),
    ('Campinas', (SELECT id_estado FROM estado WHERE nome_estado = 'São Paulo')),
    ('Santos', (SELECT id_estado FROM estado WHERE nome_estado = 'São Paulo')),
    ('Ribeirão Preto', (SELECT id_estado FROM estado WHERE nome_estado = 'São Paulo')),
    ('Rio de Janeiro', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio de Janeiro')),
    ('Niterói', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio de Janeiro')),
    ('Petrópolis', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio de Janeiro')),
    ('Volta Redonda', (SELECT id_estado FROM estado WHERE nome_estado = 'Rio de Janeiro')),
    ('Belo Horizonte', (SELECT id_estado FROM estado WHERE nome_estado = 'Minas Gerais')),
    ('Uberlândia', (SELECT id_estado FROM estado WHERE nome_estado = 'Minas Gerais')),
    ('Juiz de Fora', (SELECT id_estado FROM estado WHERE nome_estado = 'Minas Gerais')),
    ('Contagem', (SELECT id_estado FROM estado WHERE nome_estado = 'Minas Gerais')),
    ('Los Angeles', (SELECT id_estado FROM estado WHERE nome_estado = 'California')),
    ('San Francisco', (SELECT id_estado FROM estado WHERE nome_estado = 'California')),
    ('San Diego', (SELECT id_estado FROM estado WHERE nome_estado = 'California')),
    ('Sacramento', (SELECT id_estado FROM estado WHERE nome_estado = 'California')),
    ('New York City', (SELECT id_estado FROM estado WHERE nome_estado = 'New York')),
    ('Buffalo', (SELECT id_estado FROM estado WHERE nome_estado = 'New York')),
    ('Rochester', (SELECT id_estado FROM estado WHERE nome_estado = 'New York')),
    ('Albany', (SELECT id_estado FROM estado WHERE nome_estado = 'New York')),
    ('Houston', (SELECT id_estado FROM estado WHERE nome_estado = 'Texas')),
    ('Dallas', (SELECT id_estado FROM estado WHERE nome_estado = 'Texas')),
    ('Austin', (SELECT id_estado FROM estado WHERE nome_estado = 'Texas')),
    ('San Antonio', (SELECT id_estado FROM estado WHERE nome_estado = 'Texas')),
    ('Miami', (SELECT id_estado FROM estado WHERE nome_estado = 'Florida')),
    ('Orlando', (SELECT id_estado FROM estado WHERE nome_estado = 'Florida')),
    ('Tampa', (SELECT id_estado FROM estado WHERE nome_estado = 'Florida')),
    ('Jacksonville', (SELECT id_estado FROM estado WHERE nome_estado = 'Florida'));

INSERT INTO bairro (nome_bairro, fk_id_cidade) VALUES
    ('Itapuã', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Salvador')),
    ('Pelourinho', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Salvador')),
    ('Kalilândia', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Feira de Santana')),
    ('Centro', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Feira de Santana')),
    ('Recreio', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Vitória da Conquista')),
    ('Candeias', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Vitória da Conquista')),
    ('Conceição', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Itabuna')),
    ('São Caetano', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Itabuna')),
    ('Liberdade', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'São Paulo')),
    ('Moema', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'São Paulo')),
    ('Cambuí', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Campinas')),
    ('Taquaral', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Campinas')),
    ('Ponta da Praia', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Santos')),
    ('Boqueirão', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Santos')),
    ('Campos Elíseos', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Ribeirão Preto')),
    ('Jardim América', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Ribeirão Preto')),
    ('Copacabana', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Rio de Janeiro')),
    ('Ipanema', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Rio de Janeiro')),
    ('Icaraí', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Niterói')),
    ('Santa Rosa', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Niterói')),
    ('Centro', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Petrópolis')),
    ('Quitandinha', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Petrópolis')),
    ('Aterrado', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Volta Redonda')),
    ('Retiro', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Volta Redonda')),
    ('Savassi', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Belo Horizonte')),
    ('Pampulha', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Belo Horizonte')),
    ('Tibery', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Uberlândia')),
    ('Fundinho', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Uberlândia')),
    ('São Mateus', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Juiz de Fora')),
    ('Centro', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Juiz de Fora')),
    ('Eldorado', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Contagem')),
    ('Inconfidentes', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Contagem')),
    ('Hollywood', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Los Angeles')),
    ('Venice', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Los Angeles')),
    ('Chinatown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Francisco')),
    ('Mission District', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Francisco')),
    ('La Jolla', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Diego')),
    ('Gaslamp Quarter', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Diego')),
    ('Midtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Sacramento')),
    ('East Sacramento', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Sacramento')),
    ('Manhattan', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'New York City')),
    ('Brooklyn', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'New York City')),
    ('Elmwood Village', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Buffalo')),
    ('Allentown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Buffalo')),
    ('Park Avenue', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Rochester')),
    ('South Wedge', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Rochester')),
    ('Center Square', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Albany')),
    ('Pine Hills', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Albany')),
    ('Downtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Houston')),
    ('Midtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Houston')),
    ('Deep Ellum', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Dallas')),
    ('Bishop Arts District', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Dallas')),
    ('Downtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Austin')),
    ('South Congress', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Austin')),
    ('Downtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Antonio')),
    ('Alamo Heights', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'San Antonio')),
    ('South Beach', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Miami')),
    ('Little Havana', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Miami')),
    ('Downtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Orlando')),
    ('Lake Eola Heights', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Orlando')),
    ('Ybor City', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Tampa')),
    ('Hyde Park', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Tampa')),
    ('Downtown', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Jacksonville')),
    ('Riverside', (SELECT id_cidade FROM cidade WHERE nome_cidade = 'Jacksonville'));

INSERT INTO endereco (rua, num, fk_id_bairro) VALUES
    ('Rua A', floor(random() * 1000 + 1)::int,1),
    ('Rua B', floor(random() * 1000 + 1)::int,3),
    ('Rua C', floor(random() * 1000 + 1)::int,5),
    ('Rua D', floor(random() * 1000 + 1)::int,7);


INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES
     ('Guilherme Santos', 'guilherme.santos@gmail.com', 'senha123'),
     ('Lucas Almeida', 'lucas.almeida@gmail.com', 'senha456'),
     ('Angela Martins', 'angela.martins@gmail.com', 'senha789'),
     ('Roberto Silva', 'roberto.silva@gmail.com', 'senha101112');

INSERT INTO curriculo (url_foto_pessoal, cpf, data_nascimento, fk_id_usuario, fk_id_endereco) VALUES
    ('http://example.com/fotos/guilherme.jpg', '123.456.789-01', '1990-01-01', 1, 1),
    ('http://example.com/fotos/lucas.jpg', '234.567.890-12', '1992-02-02', 2, 2),
    ('http://example.com/fotos/angela.jpg', '345.678.901-23', '1994-03-03', 3, 3),
    ('http://example.com/fotos/roberto.jpg', '456.789.012-34', '1996-04-04', 4, 4);

INSERT INTO formacao (curso, status_formacao, fk_id_curriculo, data_inicio, data_termino) VALUES
    ('Engenharia da Computação', true, 1, '2010-01-01', '2014-12-31'),
    ('Mestrado em Inteligência Artificial', true, 1, '2015-01-01', '2017-12-31'),
    ('Ciência da Computação', false, 1, '2019-01-01', '2024-12-31'),
    ('Administração de Empresas', true, 2, '2011-02-01', '2015-11-30'),
    ('MBA em Gestão de Projetos', true, 2, '2016-03-01', '2018-09-30'),
    ('Engenharia de Software', false, 2, '2020-01-01', '2024-12-31'),
    ('Direito', true, 3, '2009-04-01', '2013-10-31'),
    ('Especialização em Direito Digital', true, 3, '2014-01-01', '2016-06-30'),
    ('Direito Internacional', false, 3, '2021-01-01', '2024-12-31'),
    ('Medicina', true, 4, '2008-05-01', '2014-12-31'),
    ('Residência em Cardiologia', true, 4, '2015-01-01', '2018-12-31'),
    ('Medicina Geral', false, 4, '2022-01-01', '2024-12-31');

-- Experiências para Guilherme Santos (Currículo 1)
INSERT INTO experiencia_profissional (nome_empresa, data_inicio, data_termino, status_exp_profissional, fk_id_curriculo) VALUES
    ('Empresa A', '2010-01-01', '2013-12-31', false, 1),
    ('Empresa B', '2014-02-01', '2016-03-15', false, 1),
    ('Empresa C', '2017-06-01', '2019-09-30', false, 1),
    ('Empresa D', '2020-02-01', '2022-05-15', false, 1),
    ('Empresa E', '2023-01-10', null, true, 1),
    ('Empresa F', '2011-03-15', '2014-07-31', false, 2),
    ('Empresa G', '2015-01-10', '2018-04-20', false, 2),
    ('Empresa H', '2019-02-01', '2021-06-30', false, 2),
    ('Empresa I', '2012-06-01', '2015-09-30', false, 3),
    ('Empresa J', '2016-03-01', '2018-08-31', false, 3),
    ('Empresa K', '2019-10-01', '2022-12-31', false, 3),
    ('Empresa L', '2013-08-15', '2016-11-30', false, 4),
    ('Empresa M', '2017-02-01', '2020-05-15', false, 4),
    ('Empresa N', '2021-01-10', '2023-04-30', false, 4),
    ('Empresa O', '2023-09-01', null, true, 4);

INSERT INTO pais (id_pais, nome_pais) VALUES
  (3, 'Holanda');

--Script de Criação de VIEWs
CREATE VIEW vw_usuario_curriculo_experiencia AS
SELECT
    u.nome_usuario,
    u.email_usuario,
    c.url_foto_pessoal,
    c.cpf,
    c.data_nascimento,
    ep.nome_empresa,
    ep.data_inicio,
    ep.data_termino,
    ep.status_exp_profissional
FROM usuario u
         JOIN curriculo c ON u.id_usuario = c.fk_id_usuario
         JOIN experiencia_profissional ep ON c.id_curriculo = ep.fk_id_curriculo;


CREATE VIEW vw_usuario_curriculo_endereco AS
SELECT
    u.nome_usuario,
    u.email_usuario,
    cur.url_foto_pessoal,
    cur.cpf,
    cur.data_nascimento,
    en.rua,
    p.nome_pais,
    est.nome_estado,
    cid.nome_cidade,
    b.nome_bairro

FROM usuario u
         JOIN curriculo cur ON u.id_usuario = cur.fk_id_usuario
         JOIN endereco en ON cur.fk_id_endereco = en.id_endereco
         JOIN bairro b ON b.id_bairro = en.fk_id_bairro
        JOIN cidade cid ON b.fk_id_cidade = cid.id_cidade
        JOIN estado est ON cid.fk_id_estado = est.id_estado
        JOIN pais p ON est.fk_id_pais = p.id_pais;