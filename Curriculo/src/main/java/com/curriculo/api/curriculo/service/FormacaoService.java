package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.FormacaoDTO;
import com.curriculo.api.curriculo.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoService implements FormacaoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<FormacaoDTO> rowMapper = new BeanPropertyRowMapper<>(FormacaoDTO.class);


    @Override
    public FormacaoDTO save(FormacaoDTO formacao) {
        String sql = "INSERT INTO formacao (curso, status_formacao, id_curriculo) VALUES (?,?,?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{formacao.getCurso(), formacao.isStatus_formacao(), formacao.getId_curriculo()}, Integer.class);
            formacao.setId_formacao(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formacao;
    }

    @Override
    public FormacaoDTO findById(int id) {
        String sql = "SELECT * FROM formacao WHERE id_formacao = ?";
        FormacaoDTO formacao = null;
        try {
            formacao = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formacao;
    }

    @Override
    public List<FormacaoDTO> findAll() {
        String sql = "SELECT * FROM formacao";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public FormacaoDTO update(FormacaoDTO formacao) {
        String sql = "UPDATE formacao SET curso = ?, status_formacao = ?, id_curriculo = ? WHERE id_formacao = ?";
        jdbcTemplate.update(sql, formacao.getCurso(), formacao.isStatus_formacao(), formacao.getId_curriculo(), formacao.getId_formacao());
        return formacao;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM formacao WHERE id_formacao = ?";
        jdbcTemplate.update(sql, id);
    }
}
