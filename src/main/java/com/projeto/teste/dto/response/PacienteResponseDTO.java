package com.projeto.teste.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponseDTO {

    private Long id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;
}
