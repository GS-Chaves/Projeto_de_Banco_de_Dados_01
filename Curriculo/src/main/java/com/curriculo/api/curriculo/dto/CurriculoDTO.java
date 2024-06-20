package com.curriculo.api.curriculo.dto;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CurriculoDTO {
    private int id_curriculo;
    private String url_foto_pessoal;
    private String cpf;
    private LocalDate data_nascimento;
    private int fk_id_usuario;
    private int fk_id_endereco;

}
