package com.projeto.teste.service;

import com.projeto.teste.domain.medico.Medico;
import com.projeto.teste.dto.request.MedicoRequestDTO;
import com.projeto.teste.dto.response.MedicoReponseDTO;
import com.projeto.teste.exceptions.MedicoNotFoundException;
import com.projeto.teste.repositories.MedicoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    private final ModelMapper mapper = new ModelMapper();


    public MedicoReponseDTO create(MedicoRequestDTO medicos  ) {

        Medico medicos1 = mapper.map(medicos,Medico.class);

        medicoRepository.save(medicos1);

        return mapper.map(medicos1,MedicoReponseDTO.class);

    }

    public Page<MedicoReponseDTO> find(Pageable paginacao) {

        if (paginacao == null || paginacao.getPageNumber() < 0 || paginacao.getPageSize() <= 0) {
            throw new IllegalArgumentException("Paginação inválida!");
        }
        return medicoRepository.
                findAll(paginacao).map(e -> mapper.map(e, MedicoReponseDTO.class));
    }

    public MedicoReponseDTO readById(Long id) {

        final Medico record = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Medico nao encontrado"));

        medicoRepository.save(record);

        return mapper.map(record,MedicoReponseDTO.class);
    }

    public ResponseEntity<MedicoReponseDTO> update(MedicoRequestDTO medicos, Long id) {

        return medicoRepository.findById(id)
                .map(p -> {
                    p.setNome(medicos.getNome());
                    p.setEspecialidade(medicos.getEspecialidade());
                    final Medico save = medicoRepository.save(p);
                    final MedicoReponseDTO responseDTO = mapper.map(save,MedicoReponseDTO.class);
                    return ResponseEntity.ok().body(responseDTO);

                }).orElseThrow(()-> new MedicoNotFoundException("Medico nao encontrado"));

    }

    public boolean deleteById(Long id) {
        return medicoRepository.findById(id)
                .map(delete -> {
                    medicoRepository.deleteById(id);
                    return true;
                })
                .orElseThrow(()-> new MedicoNotFoundException("Medico nao encontrado"));

    }

}
