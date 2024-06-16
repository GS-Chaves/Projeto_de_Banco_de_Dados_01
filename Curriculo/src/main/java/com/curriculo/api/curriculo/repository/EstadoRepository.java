package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.EstadoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {
    EstadoDTO save(EstadoDTO estado);

    EstadoDTO findById(int id);

    List<EstadoDTO> findAll();

    EstadoDTO update(EstadoDTO estado);

    void deleteById(int id);
}
