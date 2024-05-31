package com.curriculo.api.curriculo.repository.endereco;

import com.curriculo.api.curriculo.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EnderecoEntity> rowMapper = new BeanPropertyRowMapper<>(EnderecoEntity.class);


    @Override
    public EnderecoEntity save(EnderecoEntity endereco) {
        String sql = "INSERT INTO endereco (rua, id_bairro, id_cidade, id_estado, id_pais) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, endereco.getRua(), endereco.getId_bairro(), endereco.getId_cidade(), endereco.getId_estado(), endereco.getId_pais());
        int id = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        endereco.setId_endereco(id);
        return endereco;
    }

    @Override
    public Optional<EnderecoEntity> findById(int id) {
        String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
        EnderecoEntity enderecoEntity = null;
        try {
            enderecoEntity = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(enderecoEntity);
    }

    @Override
    public List<EnderecoEntity> findAll() {
        String sql = "SELECT * FROM endereco";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EnderecoEntity update(EnderecoEntity endereco) {
        String sql = "UPDATE endereco SET rua = ?, id_bairro = ?,id_cidade = ?,id_estado = ?,id_pais = ? WHERE id_endereco = ?";
        jdbcTemplate.update(sql, endereco.getRua(), endereco.getId_bairro(), endereco.getId_cidade(), endereco.getId_estado(), endereco.getId_pais());
        return endereco;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM endereco WHERE id_endereco = ?";
        jdbcTemplate.update(sql, id);
    }
}
