package com.projeto.teste.domain.consulta;

import com.projeto.teste.domain.medico.Medico;
import com.projeto.teste.domain.paciente.Paciente;
import com.projeto.teste.enums.TipoConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_consulta")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_paciente"))
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_medico", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_medico"))
    private Medico medico;

    @Column(name = "dh_consulta", nullable = false)
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_consulta", nullable = false)
    private TipoConsulta tipoConsulta;
}
