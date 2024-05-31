package com.curriculo.api.curriculo.repository.estado;

import com.curriculo.api.curriculo.entity.EstadoEntity;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository {
    EstadoEntity save(EstadoEntity estado);

    Optional<EstadoEntity> findById(int id);

    List<EstadoEntity> findAll();

    EstadoEntity update(EstadoEntity estado);

    void deleteById(int id);
}
