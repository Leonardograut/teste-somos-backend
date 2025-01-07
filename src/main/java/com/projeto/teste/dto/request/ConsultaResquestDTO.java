package com.projeto.teste.dto.request;

import com.projeto.teste.enums.TipoConsulta;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaResquestDTO {

    @NotNull
    private Long pacienteId;

    @NotNull
    private Long medicoId;

    @NotNull
    private LocalDateTime dataHoraConsulta;

    @NotNull
    private TipoConsulta tipoConsulta;
}
