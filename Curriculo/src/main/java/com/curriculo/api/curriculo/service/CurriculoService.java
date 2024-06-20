package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.CurriculoDTO;
import com.curriculo.api.curriculo.repository.CurriculoRepository;
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
public class CurriculoService implements CurriculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CurriculoDTO> rowMapper = new BeanPropertyRowMapper<>(CurriculoDTO.class);


    @Override
    public CurriculoDTO save(CurriculoDTO curriculo) {
        String sql = "INSERT INTO curriculo (url_foto_pessoal, cpf, data_nascimento, id_usuario) VALUES (?, ?, ?, ?)";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{curriculo.getUrl_foto_pessoal(), curriculo.getCpf(), curriculo.getData_nascimento(), curriculo.getFk_id_usuario()}, Integer.class);
            curriculo.setId_curriculo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curriculo;
    }

    @Override
    public List<CurriculoDTO> findByNome(String nome) {
        String sql = "SELECT usuario.*, curriculo.* FROM usuario INNER JOIN curriculo ON usuario.id_usuario = curriculo.id_usuario WHERE usuario.nome_usuario ILIKE ?";
        List<CurriculoDTO> curriculos = null;
        String nomeF = "'%" + nome + "%'";
        try {
            curriculos = jdbcTemplate.query(sql, new Object[]{nomeF}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curriculos;
    }

    @Override
    public CurriculoDTO findById(int id) {
        String sql = "SELECT * FROM curriculo WHERE id_curriculo = ?";
        CurriculoDTO curriculo = null;
        try {
            curriculo = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curriculo;
    }

    @Override
    public List<CurriculoDTO> findAll() {
        String sql = "SELECT * FROM curriculo";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public CurriculoDTO update(CurriculoDTO curriculo) {
        String sql = "UPDATE curriculo SET url_foto_pessoal = ?, cpf = ?, id_usuario = ? WHERE id_curriculo = ?";
        jdbcTemplate.update(sql, curriculo.getUrl_foto_pessoal(), curriculo.getCpf(), curriculo.getFk_id_usuario(), curriculo.getId_curriculo());
        return curriculo;
    }

    @Override
    public void deleteById(int id) {
        String sqlDeleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE id_curriculo = ?)";

        String sqlDeleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN " +
                "(SELECT id_curriculo FROM curriculo WHERE id_curriculo = ?)";

        String sqlDeleteCurriculo = "DELETE FROM curriculo WHERE id_curriculo = ?";

        try {
            jdbcTemplate.execute((ConnectionCallback<Object>) connection -> {
                try (PreparedStatement ps1 = connection.prepareStatement(sqlDeleteFormacao);
                     PreparedStatement ps2 = connection.prepareStatement(sqlDeleteExperienciaProfissional);
                     PreparedStatement ps3 = connection.prepareStatement(sqlDeleteCurriculo)) {

                    connection.setAutoCommit(false);
                    ps1.setInt(1, id);
                    ps1.executeUpdate();
                    ps2.setInt(1, id);
                    ps2.executeUpdate();
                    ps3.setInt(1, id);
                    ps3.executeUpdate();

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
