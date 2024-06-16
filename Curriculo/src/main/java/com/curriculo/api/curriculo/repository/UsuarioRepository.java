package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.UsuarioDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository {
    UsuarioDTO save(UsuarioDTO usuario);

    UsuarioDTO findById(int id);

    List<UsuarioDTO> findByNome(String nome);

    List<UsuarioDTO> findAll();

    UsuarioDTO update(UsuarioDTO usuario);

    void deleteById(int id);
}
