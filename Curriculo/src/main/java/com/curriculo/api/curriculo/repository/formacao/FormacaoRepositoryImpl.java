package com.curriculo.api.curriculo.repository.formacao;

import com.curriculo.api.curriculo.entity.FormacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FormacaoRepositoryImpl implements FormacaoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<FormacaoEntity> rowMapper = new BeanPropertyRowMapper<>(FormacaoEntity.class);


    @Override
    public FormacaoEntity save(FormacaoEntity formacao) {
        String sql = "INSERT INTO formacao (curso, status_formacao, id_curriculo) VALUES (?,?,?)";
        jdbcTemplate.update(sql, formacao.getCurso(), formacao.isStatus_formacao(), formacao.getId_curriculo());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        formacao.setId_formacao(id);
        return formacao;
    }

    @Override
    public Optional<FormacaoEntity> findById(int id) {
        String sql = "SELECT * FROM formacao WHERE id_formacao = ?";
        FormacaoEntity formacao = null;
        try {
            formacao = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(formacao);
    }

    @Override
    public List<FormacaoEntity> findAll() {
        String sql = "SELECT * FROM formacao";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public FormacaoEntity update(FormacaoEntity formacao) {
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
