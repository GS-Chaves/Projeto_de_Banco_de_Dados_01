package com.curriculo.api.curriculo.repository.expProfissional;

import com.curriculo.api.curriculo.entity.ExpProfissionalEntity;

import java.util.List;
import java.util.Optional;

public interface ExpProfissionalRepository {
    ExpProfissionalEntity save(ExpProfissionalEntity expProfissional);

    Optional<ExpProfissionalEntity> findById(int id);

    List<ExpProfissionalEntity> findAll();

    ExpProfissionalEntity update(ExpProfissionalEntity expProfissional);

    void deleteById(int id);
}
