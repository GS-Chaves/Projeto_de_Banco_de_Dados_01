package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.ViewUsuarioCurriculoEnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UtilsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ViewUsuarioCurriculoEnderecoDTO> rowMapper = new BeanPropertyRowMapper<>(ViewUsuarioCurriculoEnderecoDTO.class);
    public ViewUsuarioCurriculoEnderecoDTO findByName(String name) {
        String sql = "SELECT * FROM vw_usuario_curriculo_endereco WHERE nome_usuario = ?";
        ViewUsuarioCurriculoEnderecoDTO usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
