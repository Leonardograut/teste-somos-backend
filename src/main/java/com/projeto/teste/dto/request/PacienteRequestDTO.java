package com.projeto.teste.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteRequestDTO {

    @Column(name = "nm_paciente", nullable = false, length = 100)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
