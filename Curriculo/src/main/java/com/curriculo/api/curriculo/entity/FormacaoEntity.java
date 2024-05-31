package com.curriculo.api.curriculo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FormacaoEntity {
    private int id_formacao;
    private String curso;
    private boolean status_formacao;
    private int id_curriculo;
}
