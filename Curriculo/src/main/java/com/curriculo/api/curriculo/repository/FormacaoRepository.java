package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.FormacaoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormacaoRepository {
    FormacaoDTO save(FormacaoDTO formacao);

    FormacaoDTO findById(int id);

    List<FormacaoDTO> findAll();

    FormacaoDTO update(FormacaoDTO formacao);

    void deleteById(int id);
}
