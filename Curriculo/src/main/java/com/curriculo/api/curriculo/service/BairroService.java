package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.BairroDTO;
import com.curriculo.api.curriculo.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BairroService implements BairroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<BairroDTO> rowMapper = new BeanPropertyRowMapper<>(BairroDTO.class);

    @Override
    public BairroDTO save(BairroDTO bairro) {
        String sql = "INSERT INTO bairro (nome_bairro) VALUES (?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{bairro.getNome_bairro()}, Integer.class);
            bairro.setId_bairro(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }

    @Override
    public BairroDTO findById(int id) {
        String sql = "SELECT * FROM bairro WHERE id_bairro = ?";
        BairroDTO bairro = null;
        try {
            bairro = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }

    @Override
    public List<BairroDTO> findAll() {
        String sql = "SELECT * FROM bairro";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public BairroDTO update(BairroDTO bairro) {
        String sql = "UPDATE bairro SET nome_bairro = ? WHERE id_bairro = ?";
        jdbcTemplate.update(sql, bairro.getNome_bairro(), bairro.getId_bairro());
        return bairro;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bairro WHERE id_bairro = ?";
        jdbcTemplate.update(sql, id);
    }
}
