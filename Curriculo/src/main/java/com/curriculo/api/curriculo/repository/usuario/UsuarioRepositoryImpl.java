package com.curriculo.api.curriculo.repository.usuario;

import com.curriculo.api.curriculo.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UsuarioEntity> rowMapper = new BeanPropertyRowMapper<>(UsuarioEntity.class);


    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        String sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES (?,?,?)";
        jdbcTemplate.update(sql, usuario.getNome_usuario(), usuario.getEmail_usuario(), usuario.getSenha_usuario());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        usuario.setId_usuario(id);
        return usuario;
    }

    @Override
    public Optional<UsuarioEntity> findById(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        UsuarioEntity usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(usuario);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        String sql = "SELECT * FROM usuario";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuario) {
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        jdbcTemplate.update(sql, usuario.getNome_usuario(), usuario.getEmail_usuario(), usuario.getSenha_usuario(), usuario.getId_usuario());
        return usuario;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        jdbcTemplate.update(sql, id);
    }
}
