package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.ExpProfissionalDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpProfissionalRepository {
    ExpProfissionalDTO save(ExpProfissionalDTO expProfissional);

    ExpProfissionalDTO findById(int id);

    List<ExpProfissionalDTO> findAll();

    ExpProfissionalDTO update(ExpProfissionalDTO expProfissional);

    void deleteById(int id);
}
