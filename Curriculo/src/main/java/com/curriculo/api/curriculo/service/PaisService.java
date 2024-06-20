package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.PaisDTO;
import com.curriculo.api.curriculo.repository.PaisRepository;
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
public class PaisService implements PaisRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<PaisDTO> rowMapper = new BeanPropertyRowMapper<>(PaisDTO.class);


    @Override
    public PaisDTO save(PaisDTO pais) {
        String sql = "INSERT INTO pais (nome_pais) VALUES (?) RETURNING id_pais";
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
        String sqlDeleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado IN " +
                "(SELECT id_estado FROM estado WHERE fk_id_pais = ?)))))";
        String sqlDeleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado IN " +
                "(SELECT id_estado FROM estado WHERE fk_id_pais = ?)))))";

        String sqlDeleteCurriculo = "DELETE FROM curriculo WHERE fk_id_endereco IN (SELECT id_endereco FROM endereco WHERE fk_id_bairro IN (SELECT id_bairro FROM bairro WHERE fk_id_cidade IN (SELECT id_cidade FROM cidade WHERE fk_id_estado IN (SELECT id_estado FROM estado WHERE fk_id_pais = ?))))";
        String sqlDeleteEndereco = "DELETE FROM endereco WHERE fk_id_bairro IN (SELECT id_bairro FROM bairro WHERE fk_id_cidade IN (SELECT id_cidade FROM cidade WHERE fk_id_estado IN (SELECT id_estado FROM estado WHERE fk_id_pais = ?)))";
        String sqlDeleteBairro = "DELETE FROM bairro WHERE fk_id_cidade IN (SELECT id_cidade FROM cidade WHERE fk_id_estado IN (SELECT id_estado FROM estado WHERE fk_id_pais = ?))";
        String sqlDeleteCidade = "DELETE FROM cidade WHERE fk_id_estado IN (SELECT id_estado FROM estado WHERE fk_id_pais = ?)";
        String sqlDeleteEstado = "DELETE FROM estado WHERE fk_id_pais = ?";
        String sqlDeletePais = "DELETE FROM pais WHERE id_pais = ?";

        try {
            jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
                try (PreparedStatement ps1 = connection.prepareStatement(sqlDeleteCurriculo);
                     PreparedStatement ps2 = connection.prepareStatement(sqlDeleteEndereco);
                     PreparedStatement ps3 = connection.prepareStatement(sqlDeleteBairro);
                     PreparedStatement ps4 = connection.prepareStatement(sqlDeleteCidade);
                     PreparedStatement ps5 = connection.prepareStatement(sqlDeleteEstado);
                     PreparedStatement ps6 = connection.prepareStatement(sqlDeletePais);
                     PreparedStatement ps7 = connection.prepareStatement(sqlDeleteFormacao);
                     PreparedStatement ps8 = connection.prepareStatement(sqlDeleteExperienciaProfissional);
                     ) {

                    connection.setAutoCommit(false);
                    ps8.setInt(1, id);
                    ps8.executeUpdate();
                    ps7.setInt(1, id);
                    ps7.executeUpdate();
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
