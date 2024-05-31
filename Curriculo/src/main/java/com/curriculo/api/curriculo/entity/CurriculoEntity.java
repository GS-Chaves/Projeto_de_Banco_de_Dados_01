package com.curriculo.api.curriculo.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CurriculoEntity {
    private int id_curriculo;
    private String url_foto_pessoal;
    private int cpf;
    private LocalDate data_nascimento;
    private int id_usuario;
}
