package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.CurriculoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculoRepository {
    CurriculoDTO save(CurriculoDTO curriculo);

    List<CurriculoDTO> findByNome(String nome);

    CurriculoDTO findById(int id);

    List<CurriculoDTO> findAll();

    CurriculoDTO update(CurriculoDTO curriculo);

    void deleteById(int id);
}
