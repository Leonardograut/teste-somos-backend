package com.projeto.teste.domain.medico;

import com.projeto.teste.domain.consulta.Consulta;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Consulta> consultas;

}
