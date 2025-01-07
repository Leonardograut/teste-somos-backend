package com.projeto.teste.repositories;

import com.projeto.teste.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository  extends JpaRepository<Paciente,Long> {
}
