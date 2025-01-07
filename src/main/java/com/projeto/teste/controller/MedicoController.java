package com.projeto.teste.controller;

import com.projeto.teste.dto.request.MedicoRequestDTO;
import com.projeto.teste.dto.response.MedicoReponseDTO;
import com.projeto.teste.service.MedicoService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private  MedicoService medicoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicoReponseDTO> created(@RequestBody MedicoRequestDTO medicos){
        final  MedicoReponseDTO responseDTO = medicoService.create(medicos);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<MedicoReponseDTO>> find(@PageableDefault(size = 10) Pageable paginacao){
        final Page<MedicoReponseDTO> responseDTOS = medicoService.find(paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicoReponseDTO> getById(@PathVariable("id") Long id){
        final MedicoReponseDTO dto = medicoService.readById(id);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicoReponseDTO> update(@PathVariable Long id, @RequestBody MedicoRequestDTO medicoRequestDTO) {
        final MedicoReponseDTO ResponseDTO =medicoService.update(medicoRequestDTO,id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoReponseDTO> delete(@PathVariable  Long id) {
        if (medicoService.deleteById(id)) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

}
