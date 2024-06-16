package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.EstadoDTO;
import com.curriculo.api.curriculo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements EstadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EstadoDTO> rowMapper = new BeanPropertyRowMapper<>(EstadoDTO.class);


    @Override
    public EstadoDTO save(EstadoDTO estado) {
        String sql = "INSERT INTO estado (nome_estado) VALUES (?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{estado.getNome_estado()}, Integer.class);
            estado.setId_estado(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    public EstadoDTO findById(int id) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        EstadoDTO estado = null;
        try {
            estado = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    public List<EstadoDTO> findAll() {
        String sql = "SELECT * FROM estado";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EstadoDTO update(EstadoDTO estado) {
        String sql = "UPDATE estado SET nome_estado = ? WHERE id_estado = ?";
        jdbcTemplate.update(sql, estado.getNome_estado(), estado.getId_estado());
        return estado;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM estado WHERE id_estado = ?";
        jdbcTemplate.update(sql, id);
    }
}
