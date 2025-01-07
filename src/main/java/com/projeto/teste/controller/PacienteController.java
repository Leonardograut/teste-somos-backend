package com.projeto.teste.controller;

import com.projeto.teste.dto.request.MedicoRequestDTO;
import com.projeto.teste.dto.request.PacienteRequestDTO;
import com.projeto.teste.dto.response.MedicoReponseDTO;
import com.projeto.teste.dto.response.PacienteResponseDTO;
import com.projeto.teste.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {


    private PacienteService pacienteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteResponseDTO> created(@RequestBody PacienteRequestDTO pacientes){
        final PacienteResponseDTO responseDTO = pacienteService.create(pacientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PacienteResponseDTO>> find(@PageableDefault(size = 10) Pageable paginacao){
        final Page<PacienteResponseDTO> responseDTOS = pacienteService.find(paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteResponseDTO> getById(@PathVariable("id") Long id){
        final PacienteResponseDTO dto = pacienteService.readById(id);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteResponseDTO> update(@PathVariable Long id, @RequestBody PacienteRequestDTO pacienteRequestDTO) {
        final PacienteResponseDTO ResponseDTO =pacienteService.update(pacienteRequestDTO,id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoReponseDTO> delete(@PathVariable  Long id) {
        if (pacienteService.deleteById(id)) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
