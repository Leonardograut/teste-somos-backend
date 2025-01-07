package com.projeto.teste.service;

import com.projeto.teste.domain.paciente.Paciente;
import com.projeto.teste.dto.request.PacienteRequestDTO;
import com.projeto.teste.dto.response.PacienteResponseDTO;
import com.projeto.teste.exceptions.PacienteNotFountException;
import com.projeto.teste.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PacienteResponseDTO create(PacienteRequestDTO pacientes ) {

        Paciente pacientes1 = mapper.map(pacientes,Paciente.class);

        pacienteRepository.save(pacientes1);

        return mapper.map(pacientes1, PacienteResponseDTO.class);

    }

    public Page<PacienteResponseDTO> find(Pageable paginacao) {

        if (paginacao == null || paginacao.getPageNumber() < 0 || paginacao.getPageSize() <= 0) {
            throw new IllegalArgumentException("Paginação inválida!");
        }
        return pacienteRepository.
                findAll(paginacao).map(e -> mapper.map(e, PacienteResponseDTO.class));
    }

    public PacienteResponseDTO readById(Long id) {

        final Paciente record = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente nao encontrado"));

        pacienteRepository.save(record);

        return mapper.map(record,PacienteResponseDTO.class);
    }

    public ResponseEntity<PacienteResponseDTO> update(PacienteRequestDTO pacientes, Long id) {

        return pacienteRepository.findById(id)
                .map(p -> {
                    p.setNome(pacientes.getNome());
                    p.setCpf(pacientes.getCpf());
                    p.setDataNascimento(pacientes.getDataNascimento());
                    final Paciente save = pacienteRepository.save(p);
                    final PacienteResponseDTO responseDTO = mapper.map(save,PacienteResponseDTO.class);
                    return ResponseEntity.ok().body(responseDTO);

                }).orElseThrow(()-> new PacienteNotFountException("Paciente nao encontrado"));

    }

    public boolean deleteById(Long id) {
        return pacienteRepository.findById(id)
                .map(delete -> {
                    pacienteRepository.deleteById(id);
                    return true;
                })
                .orElseThrow(()-> new PacienteNotFountException("Paciente nao encontrado"));

    }
}
