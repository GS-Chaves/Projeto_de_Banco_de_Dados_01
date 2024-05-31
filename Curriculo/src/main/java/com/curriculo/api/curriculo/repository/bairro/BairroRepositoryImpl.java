package com.curriculo.api.curriculo.repository.bairro;

import com.curriculo.api.curriculo.entity.BairroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BairroRepositoryImpl implements BairroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<BairroEntity> rowMapper = new BeanPropertyRowMapper<>(BairroEntity.class);

    @Override
    public BairroEntity save(BairroEntity bairro) {
        String sql = "INSERT INTO bairro (nome_bairro) VALUES (?)";
        jdbcTemplate.update(sql, bairro.getNome_bairro());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        bairro.setId_bairro(id);
        return bairro;
    }

    @Override
    public Optional<BairroEntity> findById(int id) {
        String sql = "SELECT * FROM bairro WHERE id_bairro = ?";
        BairroEntity bairro = null;
        try {
            bairro = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(bairro);
    }

    @Override
    public List<BairroEntity> findAll() {
        String sql = "SELECT * FROM bairro";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public BairroEntity update(BairroEntity bairro) {
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
