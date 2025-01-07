CREATE TABLE pacientes (
    cd_paciente SERIAL PRIMARY KEY,
    nm_paciente VARCHAR(100) NOT NULL,
    nr_cpf VARCHAR(11) NOT NULL UNIQUE,
    dt_nascimento DATE NOT NULL
);