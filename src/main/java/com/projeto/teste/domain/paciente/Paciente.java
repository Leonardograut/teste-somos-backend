package com.projeto.teste.domain.paciente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_paciente")
    private Long id;

    @Column(name = "nm_paciente", nullable = false, length = 100)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
