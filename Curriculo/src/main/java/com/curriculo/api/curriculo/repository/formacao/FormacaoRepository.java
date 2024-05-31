package com.curriculo.api.curriculo.repository.formacao;

import com.curriculo.api.curriculo.entity.FormacaoEntity;

import java.util.List;
import java.util.Optional;

public interface FormacaoRepository {
    FormacaoEntity save(FormacaoEntity formacao);

    Optional<FormacaoEntity> findById(int id);

    List<FormacaoEntity> findAll();

    FormacaoEntity update(FormacaoEntity formacao);

    void deleteById(int id);
}
