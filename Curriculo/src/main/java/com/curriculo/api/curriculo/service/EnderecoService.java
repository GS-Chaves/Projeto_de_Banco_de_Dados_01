package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.EnderecoDTO;
import com.curriculo.api.curriculo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements EnderecoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EnderecoDTO> rowMapper = new BeanPropertyRowMapper<>(EnderecoDTO.class);


    @Override
    public EnderecoDTO save(EnderecoDTO endereco) {
        String sql = "INSERT INTO endereco (rua, id_bairro, id_cidade, id_estado, id_pais) VALUES (?,?,?,?,?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{endereco.getRua(), endereco.getId_bairro(), endereco.getId_cidade(), endereco.getId_estado(), endereco.getId_pais()}, Integer.class);
            endereco.setId_endereco(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public EnderecoDTO findById(int id) {
        String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
        EnderecoDTO endereco = null;
        try {
            endereco = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public List<EnderecoDTO> findAll() {
        String sql = "SELECT * FROM endereco";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EnderecoDTO update(EnderecoDTO endereco) {
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
