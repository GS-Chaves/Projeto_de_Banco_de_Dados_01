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

CREATE VIEW vw_usuario_sem_senha AS
SELECT
    u.nome_usuario,
    u.email_usuario,
    c.url_foto_pessoal,
    c.cpf,
    c.data_nascimento

FROM usuario u
         JOIN curriculo c ON c.fk_id_usuario = u.id_usuario;