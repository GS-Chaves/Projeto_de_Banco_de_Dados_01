package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.FormacaoEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FormacaoDTO {
    private int id_formacao;
    private String curso;
    private boolean status_formacao;
    private int fk_id_curriculo;
    public FormacaoDTO(FormacaoEntity formacaoEntity){
        BeanUtils.copyProperties(formacaoEntity, this);
    }
}
