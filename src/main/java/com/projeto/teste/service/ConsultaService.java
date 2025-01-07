package com.projeto.teste.service;

import com.projeto.teste.domain.consulta.Consulta;
import com.projeto.teste.domain.medico.Medico;
import com.projeto.teste.domain.paciente.Paciente;
import com.projeto.teste.dto.request.ConsultaResquestDTO;
import com.projeto.teste.dto.response.ConsultaReponseDTO;
import com.projeto.teste.exceptions.ConsultaNotFoundException;
import com.projeto.teste.exceptions.MedicoNotFoundException;
import com.projeto.teste.exceptions.PacienteNotFountException;
import com.projeto.teste.repositories.ConsultaRepository;
import com.projeto.teste.repositories.MedicoRepository;
import com.projeto.teste.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ConsultaService {

    private final MedicoRepository medicoRepository;

    private final ConsultaRepository consultaRepository;

    private final PacienteRepository pacienteRepository;

    private final ModelMapper mapper = new ModelMapper();


    public ConsultaReponseDTO create(ConsultaResquestDTO consultas ) {

        Medico medico = medicoRepository.findById(consultas.getMedicoId())
                .orElseThrow(() -> new MedicoNotFoundException("Médico não encontrado."));
        Paciente paciente = pacienteRepository.findById(consultas.getPacienteId())
                .orElseThrow(() -> new PacienteNotFountException("Paciente não encontrado."));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHoraConsulta(consultas.getDataHoraConsulta());
        consulta.setTipoConsulta(consultas.getTipoConsulta());

        consultaRepository.save(consulta);

        return mapper.map(consulta,ConsultaReponseDTO.class);

    }

    public Page<ConsultaReponseDTO> find(Pageable paginacao) {

        if (paginacao == null || paginacao.getPageNumber() < 0 || paginacao.getPageSize() <= 0) {
            throw new IllegalArgumentException("Paginação inválida!");
        }
        return consultaRepository.
                findAll(paginacao).map(e -> mapper.map(e, ConsultaReponseDTO.class));
    }


    public ConsultaReponseDTO readById(Long id) {

        final Consulta record = consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNotFoundException("Consulta nao encontrada"));

        consultaRepository.save(record);

        return mapper.map(record,ConsultaReponseDTO.class);
    }

    public ResponseEntity<ConsultaReponseDTO> update(ConsultaResquestDTO consultas, Long id) {

        return consultaRepository.findById(id)
                .map(p -> {
                    p.setDataHoraConsulta(consultas.getDataHoraConsulta());
                    p.setTipoConsulta(consultas.getTipoConsulta());
                    final Consulta save = consultaRepository.save(p);
                    final ConsultaReponseDTO responseDTO = mapper.map(save,ConsultaReponseDTO.class);
                    return ResponseEntity.ok().body(responseDTO);

                }).orElseThrow(()-> new ConsultaNotFoundException("Consulta nao encontrada"));

    }


    public boolean deleteById(Long id) {
        return consultaRepository.findById(id)
                .map(delete -> {
                    consultaRepository.deleteById(id);
                    return true;
                })
                .orElseThrow(()-> new ConsultaNotFoundException("Consulta nao encontrada"));

    }
}
