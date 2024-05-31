package com.curriculo.api.curriculo.repository.pais;

import com.curriculo.api.curriculo.entity.PaisEntity;

import java.util.List;
import java.util.Optional;

public interface PaisRepository {
    PaisEntity save(PaisEntity pais);

    Optional<PaisEntity> findById(int id);

    List<PaisEntity> findAll();

    PaisEntity update(PaisEntity pais);

    void deleteById(int id);
}
