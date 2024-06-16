package com.curriculo.api.curriculo.service;


import com.curriculo.api.curriculo.dto.UsuarioDTO;
import com.curriculo.api.curriculo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService implements UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UsuarioDTO> rowMapper = new BeanPropertyRowMapper<>(UsuarioDTO.class);


    @Override
    public UsuarioDTO save(UsuarioDTO usuario) {
        String sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?) RETURNING id_usuario";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{usuario.getNome_usuario(), usuario.getEmail_usuario(), usuario.getSenha_usuario()}, Integer.class);
            usuario.setId_usuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }


    @Override
    public UsuarioDTO findById(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        UsuarioDTO usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e){
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<UsuarioDTO> findByNome(String nome) {
        String sql = "SELECT usuario.*, curriculo.* FROM usuario INNER JOIN curriculo ON usuario.id_usuario = curriculo.id_usuario WHERE usuario.nome_usuario LIKE '%e%'";
        List<UsuarioDTO> usuarios = null;
        try {
            usuarios = jdbcTemplate.query(sql, new Object[]{nome}, rowMapper);
        } catch (Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }


    @Override
    public List<UsuarioDTO> findAll() {
        String sql = "SELECT * FROM usuario";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuario) {
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
