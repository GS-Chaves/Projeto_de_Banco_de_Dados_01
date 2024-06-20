package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.BairroDTO;
import com.curriculo.api.curriculo.repository.BairroRepository;
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
public class BairroService implements BairroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<BairroDTO> rowMapper = new BeanPropertyRowMapper<>(BairroDTO.class);

    @Override
    public BairroDTO save(BairroDTO bairro) {
        String sql = "INSERT INTO bairro (nome_bairro) VALUES (?) RETURNING id_bairro";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{bairro.getNome_bairro()}, Integer.class);
            bairro.setId_bairro(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }

    @Override
    public BairroDTO findById(int id) {
        String sql = "SELECT * FROM bairro WHERE id_bairro = ?";
        BairroDTO bairro = null;
        try {
            bairro = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }

    @Override
    public List<BairroDTO> findAll() {
        String sql = "SELECT * FROM bairro";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public BairroDTO update(BairroDTO bairro) {
        String sql = "UPDATE bairro SET nome_bairro = ? WHERE id_bairro = ?";
        jdbcTemplate.update(sql, bairro.getNome_bairro(), bairro.getId_bairro());
        return bairro;
    }

    @Override
    public void deleteById(int id) {
        String sqlDeleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro = ?))";

        String sqlDeleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro = ?))";

        String sqlDeleteCurriculo = "DELETE FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro = ?)";

        String sqlDeleteEndereco = "DELETE FROM endereco WHERE fk_id_bairro = ?";

        String sqlDeleteBairro = "DELETE FROM bairro WHERE id_bairro = ?";

        try {
            jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
                try (PreparedStatement ps1 = connection.prepareStatement(sqlDeleteFormacao);
                     PreparedStatement ps2 = connection.prepareStatement(sqlDeleteExperienciaProfissional);
                     PreparedStatement ps3 = connection.prepareStatement(sqlDeleteCurriculo);
                     PreparedStatement ps4 = connection.prepareStatement(sqlDeleteEndereco);
                     PreparedStatement ps5 = connection.prepareStatement(sqlDeleteBairro)) {

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
