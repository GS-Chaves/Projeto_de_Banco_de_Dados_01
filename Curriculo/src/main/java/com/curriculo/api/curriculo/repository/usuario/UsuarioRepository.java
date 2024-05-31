package com.curriculo.api.curriculo.repository.usuario;

import com.curriculo.api.curriculo.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    UsuarioEntity save(UsuarioEntity usuario);

    Optional<UsuarioEntity> findById(int id);

    List<UsuarioEntity> findAll();

    UsuarioEntity update(UsuarioEntity usuario);

    void deleteById(int id);
}
