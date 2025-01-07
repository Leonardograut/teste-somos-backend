package com.projeto.teste.domain.medico;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_medico")
    private Long id;

    @Column(name = "nm_medico", nullable = false, length = 100)
    private String nome;

    @Column(name = "nm_especialidade", nullable = false, length = 100)
    private String especialidade;

}
