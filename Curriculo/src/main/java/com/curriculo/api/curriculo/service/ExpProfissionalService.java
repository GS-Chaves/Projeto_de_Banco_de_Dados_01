package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.ExpProfissionalDTO;
import com.curriculo.api.curriculo.repository.ExpProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpProfissionalService implements ExpProfissionalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ExpProfissionalDTO> rowMapper = new BeanPropertyRowMapper<>(ExpProfissionalDTO.class);


    @Override
    public ExpProfissionalDTO save(ExpProfissionalDTO expProfissional) {
        String sql = "INSERT INTO experiencia_profissional (nome_empresa, data_inicio, data_termino, status_exp_profissional, id_curriculo) VALUES (?,?,?,?,?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{expProfissional.getNome_empresa(), expProfissional.getData_inicio(), expProfissional.getData_termino(), expProfissional.isStatus_exp_profissional(), expProfissional.getId_curriculo()}, Integer.class);
            expProfissional.setId_exp_profissional(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expProfissional;
    }

    @Override
    public ExpProfissionalDTO findById(int id) {
        String sql = "SELECT FROM experiencia_profissional WHERE id_exp_profissional = ?";
        ExpProfissionalDTO expProfissional = null;
        try {
            expProfissional = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expProfissional;
    }

    @Override
    public List<ExpProfissionalDTO> findAll() {
        String sql = "SELECT * FROM experiencia_profissional";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public ExpProfissionalDTO update(ExpProfissionalDTO expProfissional) {
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
