package com.curriculo.api.curriculo.repository.curriculo;

import com.curriculo.api.curriculo.entity.CurriculoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CurriculoRepositoryImpl implements CurriculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CurriculoEntity> rowMapper = new BeanPropertyRowMapper<>(CurriculoEntity.class);


    @Override
    public CurriculoEntity save(CurriculoEntity curriculo) {
        String sql = "INSERT INTO curriculo (url_foto_pessoal, cpf, data_nascimento, id_usuario) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, curriculo.getUrl_foto_pessoal(), curriculo.getCpf(), curriculo.getData_nascimento(), curriculo.getId_usuario());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        curriculo.setId_curriculo(id);
        return curriculo;
    }

    @Override
    public Optional<CurriculoEntity> findById(int id) {
        String sql = "SELECT * FROM curriculo WHERE id_curriculo = ?";
        CurriculoEntity curriculo = null;
        try {
            curriculo = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(curriculo);
    }

    @Override
    public List<CurriculoEntity> findAll() {
        String sql = "SELECT * FROM curriculo";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public CurriculoEntity update(CurriculoEntity curriculo) {
        String sql = "UPDATE curriculo SET url_foto_pessoal = ?, cpf = ?, id_usuario = ? WHERE id_curriculo = ?";
        jdbcTemplate.update(sql, curriculo.getUrl_foto_pessoal(), curriculo.getCpf(), curriculo.getId_usuario(), curriculo.getId_curriculo());
        return curriculo;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM curriculo WHERE id_curriculo = ?";
        jdbcTemplate.update(sql, id);
    }
}
