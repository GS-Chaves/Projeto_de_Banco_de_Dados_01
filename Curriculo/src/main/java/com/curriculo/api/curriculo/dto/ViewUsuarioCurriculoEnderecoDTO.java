package com.curriculo.api.curriculo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ViewUsuarioCurriculoEnderecoDTO {
    private String nome_usuario;
    private String email_usuario;
    private String url_foto_pessoal;
    private String cpf;
    private LocalDate data_nascimento;
    private String rua;
    private String nome_pais;
    private String nome_estado;
    private String nome_cidade;
    private String nome_bairro;
}
