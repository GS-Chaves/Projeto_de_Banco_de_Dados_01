package com.curriculo.api.curriculo.repository;

import com.curriculo.api.curriculo.dto.EnderecoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository {
    EnderecoDTO save(EnderecoDTO endereco);

    EnderecoDTO findById(int id);

    List<EnderecoDTO> findAll();

    EnderecoDTO update(EnderecoDTO endereco);

    void deleteById(int id);
}
