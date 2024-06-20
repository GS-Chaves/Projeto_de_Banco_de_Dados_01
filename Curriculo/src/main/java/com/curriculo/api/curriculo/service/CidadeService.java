package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.CidadeDTO;
import com.curriculo.api.curriculo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class CidadeService implements CidadeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CidadeDTO> rowMapper = new BeanPropertyRowMapper<>(CidadeDTO.class);


    @Override
    public CidadeDTO save(CidadeDTO cidade) {
        String sql = "INSERT INTO cidade (nome_cidade, fk_id_estado) VALUES (?, ?) RETURNING id_cidade";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{cidade.getNome_cidade(), cidade.getFk_id_estado()}, Integer.class);
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
        String sql = "UPDATE cidade SET nome_cidade = ?, fk_id_estado =? WHERE id_cidade = ?";
        jdbcTemplate.update(sql, cidade.getNome_cidade(),cidade.getFk_id_estado(), cidade.getId_cidade());
        return cidade;
    }

    @Override
    public void deleteById(int id) {
        String sqlDeleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade = ?)))";

        String sqlDeleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade = ?)))";

        String sqlDeleteCurriculo = "DELETE FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade = ?))";

        String sqlDeleteEndereco = "DELETE FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade = ?)";

        String sqlDeleteBairro = "DELETE FROM bairro WHERE fk_id_cidade = ?";

        String sqlDeleteCidade = "DELETE FROM cidade WHERE id_cidade = ?";

        try {
            jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
                try (PreparedStatement ps1 = connection.prepareStatement(sqlDeleteFormacao);
                     PreparedStatement ps2 = connection.prepareStatement(sqlDeleteExperienciaProfissional);
                     PreparedStatement ps3 = connection.prepareStatement(sqlDeleteCurriculo);
                     PreparedStatement ps4 = connection.prepareStatement(sqlDeleteEndereco);
                     PreparedStatement ps5 = connection.prepareStatement(sqlDeleteBairro);
                     PreparedStatement ps6 = connection.prepareStatement(sqlDeleteCidade)) {

                    connection.setAutoCommit(false);
                    ps1.setInt(1, id);
                    ps1.executeUpdate();
                    ps2.setInt(1, id);
                    ps2.executeUpdate();
                    ps3.setInt(1, id);
                    ps3.executeUpdate();
                    ps4.setInt(1, id);
                    ps4.executeUpdate();
                    ps5.setInt(1, id);
                    ps5.executeUpdate();
                    ps6.setInt(1, id);
                    ps6.executeUpdate();

                    connection.commit();
                    return null;
                } catch (SQLException e) {
                    connection.rollback();
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
