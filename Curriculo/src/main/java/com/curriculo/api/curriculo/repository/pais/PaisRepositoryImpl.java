package com.curriculo.api.curriculo.repository.pais;

import com.curriculo.api.curriculo.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaisRepositoryImpl implements PaisRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<PaisEntity> rowMapper = new BeanPropertyRowMapper<>(PaisEntity.class);


    @Override
    public PaisEntity save(PaisEntity pais) {
        String sql = "INSERT INTO pais (nome_pais) VALUES (?)";
        jdbcTemplate.update(sql, pais.getNome_pais());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        pais.setId_pais(id);
        return pais;
    }

    @Override
    public Optional<PaisEntity> findById(int id) {
        String sql = "SELECT * FROM pais WHERE id_pais = ?";
        PaisEntity pais = null;
        try {
            pais = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(pais);
    }

    @Override
    public List<PaisEntity> findAll() {
        String sql = "SELECT * FROM pais";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public PaisEntity update(PaisEntity pais) {
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
