package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.FormacaoDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

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

    public FormacaoEntity(FormacaoDTO formacaoDTO) {
        BeanUtils.copyProperties(formacaoDTO, this);
    }
}
