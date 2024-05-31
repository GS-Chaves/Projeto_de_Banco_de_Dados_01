package com.curriculo.api.curriculo.repository.curriculo;

import com.curriculo.api.curriculo.entity.CurriculoEntity;

import java.util.List;
import java.util.Optional;

public interface CurriculoRepository {
    CurriculoEntity save(CurriculoEntity curriculo);

    Optional<CurriculoEntity> findById(int id);

    List<CurriculoEntity> findAll();

    CurriculoEntity update(CurriculoEntity curriculo);

    void deleteById(int id);
}
