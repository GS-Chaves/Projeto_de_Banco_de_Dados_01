package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.CidadeDTO;
import com.curriculo.api.curriculo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService implements CidadeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CidadeDTO> rowMapper = new BeanPropertyRowMapper<>(CidadeDTO.class);


    @Override
    public CidadeDTO save(CidadeDTO cidade) {
        String sql = "INSERT INTO cidade (nome_cidade) VALUES (?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{cidade.getNome_cidade()}, Integer.class);
            cidade.setId_cidade(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidade;
    }

    @Override
    public CidadeDTO findById(int id) {
        String sql = "SELECT * FROM cidade WHERE id_cidade = ?";
        CidadeDTO cidade = null;
        try {
            cidade = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidade;
    }

    @Override
    public List<CidadeDTO> findAll() {
        String sql = "SELECT * FROM cidade";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public CidadeDTO update(CidadeDTO cidade) {
        String sql = "UPDATE cidade SET nome_cidade = ? WHERE id_cidade = ?";
        jdbcTemplate.update(sql, cidade.getNome_cidade(), cidade.getId_cidade());
        return cidade;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM cidade WHERE id_cidade = ?";
        jdbcTemplate.update(sql, id);
    }
}
