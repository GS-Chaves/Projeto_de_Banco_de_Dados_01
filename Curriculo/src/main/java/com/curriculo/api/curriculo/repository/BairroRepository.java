package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.BairroDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BairroRepository {
    BairroDTO save(BairroDTO bairro);

    BairroDTO findById(int id);

    List<BairroDTO> findAll();

    BairroDTO update(BairroDTO bairro);

    void deleteById(int id);
}
