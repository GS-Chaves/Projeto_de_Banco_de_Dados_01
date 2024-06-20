package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.EstadoDTO;
import com.curriculo.api.curriculo.repository.EstadoRepository;
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
public class EstadoService implements EstadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EstadoDTO> rowMapper = new BeanPropertyRowMapper<>(EstadoDTO.class);


    @Override
    public EstadoDTO save(EstadoDTO estado) {
        String sql = "INSERT INTO estado (nome_estado, fk_id_pais) VALUES (?, ?) RETURNING id_estado";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{estado.getNome_estado(), estado.getFk_id_pais()}, Integer.class);
            estado.setId_estado(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    public EstadoDTO findById(int id) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        EstadoDTO estado = null;
        try {
            estado = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    public List<EstadoDTO> findAll() {
        String sql = "SELECT * FROM estado";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public EstadoDTO update(EstadoDTO estado) {
        String sql = "UPDATE estado SET nome_estado = ?, fk_id_pais = ? WHERE id_estado = ?";
        jdbcTemplate.update(sql, estado.getNome_estado(), estado.getFk_id_pais(),estado.getId_estado());
        return estado;
    }

    @Override
    public void deleteById(int id) {
        String sqlDeleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado = ?))))";

        String sqlDeleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado = ?))))";

        String sqlDeleteCurriculo = "DELETE FROM curriculo WHERE fk_id_endereco IN " +
                "(SELECT id_endereco FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado = ?)))";

        String sqlDeleteEndereco = "DELETE FROM endereco WHERE fk_id_bairro IN " +
                "(SELECT id_bairro FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado = ?))";

        String sqlDeleteBairro = "DELETE FROM bairro WHERE fk_id_cidade IN " +
                "(SELECT id_cidade FROM cidade WHERE fk_id_estado = ?)";

        String sqlDeleteCidade = "DELETE FROM cidade WHERE fk_id_estado = ?";

        String sqlDeleteEstado = "DELETE FROM estado WHERE id_estado = ?";

        try {
            jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
                try (PreparedStatement ps1 = connection.prepareStatement(sqlDeleteFormacao);
                     PreparedStatement ps2 = connection.prepareStatement(sqlDeleteExperienciaProfissional);
                     PreparedStatement ps3 = connection.prepareStatement(sqlDeleteCurriculo);
                     PreparedStatement ps4 = connection.prepareStatement(sqlDeleteEndereco);
                     PreparedStatement ps5 = connection.prepareStatement(sqlDeleteBairro);
                     PreparedStatement ps6 = connection.prepareStatement(sqlDeleteCidade);
                     PreparedStatement ps7 = connection.prepareStatement(sqlDeleteEstado)) {

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
                    ps7.setInt(1, id);
                    ps7.executeUpdate();

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
