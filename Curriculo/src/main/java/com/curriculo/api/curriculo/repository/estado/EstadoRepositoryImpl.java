package com.curriculo.api.curriculo.repository.estado;

import com.curriculo.api.curriculo.entity.EstadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EstadoEntity> rowMapper = new BeanPropertyRowMapper<>(EstadoEntity.class);


    @Override
    public EstadoEntity save(EstadoEntity estado) {
        String sql = "INSERT INTO estado (nome_estado) VALUES (?)";
        jdbcTemplate.update(sql, estado.getNome_estado());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        estado.setId_estado(id);
        return estado;
    }

    @Override
    public Optional<EstadoEntity> findById(int id) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        EstadoEntity estado = null;
        try {
            estado = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(estado);
    }

    @Override
    public List<EstadoEntity> findAll() {
        String sql = "SELECT * FROM estado";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EstadoEntity update(EstadoEntity estado) {
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
