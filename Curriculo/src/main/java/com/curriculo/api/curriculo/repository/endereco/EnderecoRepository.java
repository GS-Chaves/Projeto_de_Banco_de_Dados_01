package com.curriculo.api.curriculo.repository.endereco;

import com.curriculo.api.curriculo.entity.EnderecoEntity;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository {
    EnderecoEntity save(EnderecoEntity endereco);

    Optional<EnderecoEntity> findById(int id);

    List<EnderecoEntity> findAll();

    EnderecoEntity update(EnderecoEntity endereco);

    void deleteById(int id);
}
