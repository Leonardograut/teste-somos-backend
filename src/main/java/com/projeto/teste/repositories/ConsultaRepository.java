package com.projeto.teste.repositories;

import com.projeto.teste.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
}
