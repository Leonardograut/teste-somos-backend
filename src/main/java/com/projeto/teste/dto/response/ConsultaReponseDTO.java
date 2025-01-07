package com.projeto.teste.dto.response;

import com.projeto.teste.enums.TipoConsulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaReponseDTO {

    private Long id;
    private Long pacienteId;
    private String pacienteNome;
    private Long medicoId;
    private String medicoNome;
    private LocalDateTime dataHoraConsulta;
    private TipoConsulta tipoConsulta;
}
