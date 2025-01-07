package com.projeto.teste.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoReponseDTO {

    private Long id;

    private String nome;

    private String especialidade;
}
