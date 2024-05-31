package com.curriculo.api.curriculo.repository.cidade;

import com.curriculo.api.curriculo.entity.CidadeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CidadeEntity> rowMapper = new BeanPropertyRowMapper<>(CidadeEntity.class);


    @Override
    public CidadeEntity save(CidadeEntity cidade) {
        String sql = "INSERT INTO cidade (nome_cidade) VALUES (?)";
        jdbcTemplate.update(sql, cidade.getNome_cidade());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        cidade.setId_cidade(id);
        return cidade;
    }

    @Override
    public Optional<CidadeEntity> findById(int id) {
        String sql = "SELECT * FROM cidade WHERE id_cidade = ?";
        CidadeEntity cidade = null;
        try {
            cidade = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(cidade);
    }

    @Override
    public List<CidadeEntity> findAll() {
        String sql = "SELECT * FROM cidade";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public CidadeEntity update(CidadeEntity cidade) {
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
