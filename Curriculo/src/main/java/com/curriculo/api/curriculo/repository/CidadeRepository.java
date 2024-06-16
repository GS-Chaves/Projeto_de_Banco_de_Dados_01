package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.CidadeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository {
    CidadeDTO save(CidadeDTO cidade);

    CidadeDTO findById(int id);

    List<CidadeDTO> findAll();

    CidadeDTO update(CidadeDTO cidade);

    void deleteById(int id);
}
