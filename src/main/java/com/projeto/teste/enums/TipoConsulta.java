package com.projeto.teste.enums;

import lombok.AllArgsConstructor;

public enum TipoConsulta {

    P("Particular"),
    S("SUS");

    private final String descricao;

    TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
