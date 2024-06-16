package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.PaisDTO;
import com.curriculo.api.curriculo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService implements PaisRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<PaisDTO> rowMapper = new BeanPropertyRowMapper<>(PaisDTO.class);


    @Override
    public PaisDTO save(PaisDTO pais) {
        String sql = "INSERT INTO pais (nome_pais) VALUES (?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{pais.getNome_pais()}, Integer.class);
            pais.setId_pais(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return pais;
    }

    @Override
    public PaisDTO findById(int id) {
        String sql = "SELECT * FROM pais WHERE id_pais = ?";
        PaisDTO pais = null;
        try {
            pais = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pais;
    }

    @Override
    public List<PaisDTO> findAll() {
        String sql = "SELECT * FROM pais";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public PaisDTO update(PaisDTO pais) {
        String sql = "UPDATE pais SET nome_pais = ? WHERE id_pais = ?";
        jdbcTemplate.update(sql, pais.getNome_pais(), pais.getId_pais());
        return pais;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM pais WHERE id_pais = ?";
        jdbcTemplate.update(sql, id);
    }
}
