package com.curriculo.api.curriculo.repository.cidade;

import com.curriculo.api.curriculo.entity.CidadeEntity;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository {
    CidadeEntity save(CidadeEntity cidade);

    Optional<CidadeEntity> findById(int id);

    List<CidadeEntity> findAll();

    CidadeEntity update(CidadeEntity cidade);

    void deleteById(int id);
}
