package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.PaisDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository {
    PaisDTO save(PaisDTO pais);

    PaisDTO findById(int id);

    List<PaisDTO> findAll();

    PaisDTO update(PaisDTO pais);

    void deleteById(int id);
}
