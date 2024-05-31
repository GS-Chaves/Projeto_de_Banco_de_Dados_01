package com.curriculo.api.curriculo.repository.expProfissional;

import com.curriculo.api.curriculo.entity.ExpProfissionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExpProfissionalRepositoryImpl implements ExpProfissionalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ExpProfissionalEntity> rowMapper = new BeanPropertyRowMapper<>(ExpProfissionalEntity.class);


    @Override
    public ExpProfissionalEntity save(ExpProfissionalEntity expProfissional) {
        String sql = "INSERT INTO experiencia_profissional (nome_empresa, data_inicio, data_termino, status_exp_profissional, id_curriculo) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, expProfissional.getNome_empresa(), expProfissional.getData_inicio(), expProfissional.getData_termino(), expProfissional.getId_curriculo());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        expProfissional.setId_exp_profissional(id);
        return expProfissional;
    }

    @Override
    public Optional<ExpProfissionalEntity> findById(int id) {
        String sql = "SELECT FROM experiencia_profissional WHERE id_exp_profissional = ?";
        ExpProfissionalEntity expProfissional = null;
        try {
            expProfissional = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(expProfissional);
    }

    @Override
    public List<ExpProfissionalEntity> findAll() {
        String sql = "SELECT * FROM experiencia_profissional";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public ExpProfissionalEntity update(ExpProfissionalEntity expProfissional) {
        String sql = "UPDATE experiencia_profissional SET nome_empresa = ?, data_inicio = ?, data_termino = ?, status_exp_profissional = ?, id_curriculo = ? WHERE id_exp_profissional = ?";
        jdbcTemplate.update(sql, expProfissional.getNome_empresa(), expProfissional.getData_inicio(), expProfissional.getData_termino(), expProfissional.isStatus_exp_profissional(), expProfissional.getId_curriculo(), expProfissional.getId_exp_profissional());
        return expProfissional;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM experiencia_profissional WHERE id_exp_profissional = ?";
        jdbcTemplate.update(sql, id);
    }
}
