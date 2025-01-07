CREATE TABLE consultas (
    cd_consulta SERIAL PRIMARY KEY,
    cd_paciente INT NOT NULL,
    cd_medico INT NOT NULL,
    dh_consulta TIMESTAMP NOT NULL,
    tp_consulta CHAR(1) NOT NULL CHECK (tp_consulta IN ('P', 'S')),
    CONSTRAINT fk_consulta_paciente FOREIGN KEY (cd_paciente) REFERENCES pacientes (cd_paciente),
    CONSTRAINT fk_consulta_medico FOREIGN KEY (cd_medico) REFERENCES medicos (cd_medico)
);