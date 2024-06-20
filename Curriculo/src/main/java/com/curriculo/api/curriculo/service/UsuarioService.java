package com.curriculo.api.curriculo.service;

import com.curriculo.api.curriculo.dto.CurriculoDTO;
import com.curriculo.api.curriculo.dto.UsuarioDTO;
import com.curriculo.api.curriculo.dto.ViewUsuarioSemSenhaDTO;
import com.curriculo.api.curriculo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService implements UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UsuarioDTO> rowMapper = new BeanPropertyRowMapper<>(UsuarioDTO.class);
    private RowMapper<ViewUsuarioSemSenhaDTO> rowMapperAllUsers = new BeanPropertyRowMapper<>(ViewUsuarioSemSenhaDTO.class);
    private static class UsuarioDTORowMapper implements RowMapper<UsuarioDTO> {
        @Override
        public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            CurriculoDTO curriculo = new CurriculoDTO(
                    rs.getInt("id_curriculo"),
                    rs.getString("url_foto_pessoal"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento").toLocalDate(),
                    rs.getInt("fk_id_usuario"),
                    rs.getInt("fk_id_endereco")
            );

            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setNome_usuario(rs.getString("nome_usuario"));
            usuario.setEmail_usuario(rs.getString("email_usuario"));
            usuario.setSenha_usuario(rs.getString("senha_usuario"));
            usuario.setObj_curriculo(curriculo);

            return usuario;
        }
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) {
        String sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?) RETURNING id_usuario";
        try {
            int id = jdbcTemplate.queryForObject(sql, new Object[]{usuario.getNome_usuario(), usuario.getEmail_usuario(), usuario.getSenha_usuario()}, Integer.class);
            usuario.setId_usuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public UsuarioDTO findById(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        UsuarioDTO usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public UsuarioDTO findByNome(String nome) {
        String sql = "SELECT u.id_usuario, u.nome_usuario, u.email_usuario, u.senha_usuario, " +
                "c.id_curriculo, c.url_foto_pessoal, c.cpf, c.data_nascimento, c.fk_id_usuario, c.fk_id_endereco " +
                "FROM usuario u " +
                "INNER JOIN curriculo c ON u.id_usuario = c.fk_id_usuario " +
                "WHERE u.nome_usuario = ?";
        UsuarioDTO usuario = null;
        try {
            usuario = jdbcTemplate.queryForObject(sql, new Object[]{nome}, new UsuarioDTORowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<ViewUsuarioSemSenhaDTO> findAll() {
        String sql = "SELECT * FROM vw_usuario_sem_senha";
        return jdbcTemplate.query(sql, rowMapperAllUsers);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuario) {
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        jdbcTemplate.update(sql, usuario.getNome_usuario(), usuario.getEmail_usuario(), usuario.getSenha_usuario(), usuario.getId_usuario());
        return usuario;
    }

    @Override
    public void deleteById(int id) {
        String deleteExperienciaProfissional = "DELETE FROM experiencia_profissional WHERE fk_id_curriculo IN (SELECT id_curriculo FROM curriculo WHERE fk_id_usuario = ?)";
        String deleteFormacao = "DELETE FROM formacao WHERE fk_id_curriculo IN (SELECT id_curriculo FROM curriculo WHERE fk_id_usuario = ?)";
        String deleteCurriculo = "DELETE FROM curriculo WHERE fk_id_usuario = ?";

        // Executar as queries na ordem correta
        jdbcTemplate.update(deleteExperienciaProfissional, id);
        jdbcTemplate.update(deleteFormacao, id);
        jdbcTemplate.update(deleteCurriculo, id);

        // Finalmente, deletar o usuário
        String deleteUsuario = "DELETE FROM usuario WHERE id_usuario = ?";
        jdbcTemplate.update(deleteUsuario, id);
    }

}
