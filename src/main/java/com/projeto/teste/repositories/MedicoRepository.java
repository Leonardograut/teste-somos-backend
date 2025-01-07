package com.projeto.teste.repositories;

import com.projeto.teste.domain.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
