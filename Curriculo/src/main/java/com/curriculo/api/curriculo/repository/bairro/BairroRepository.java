package com.curriculo.api.curriculo.repository.bairro;

import com.curriculo.api.curriculo.entity.BairroEntity;

import java.util.List;
import java.util.Optional;

public interface BairroRepository {
    BairroEntity save(BairroEntity bairro);
    Optional<BairroEntity> findById(int id);
    List<BairroEntity> findAll();
    BairroEntity update(BairroEntity bairro);
    void deleteById(int id);
}
