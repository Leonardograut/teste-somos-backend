package com.projeto.teste.controller;

import com.projeto.teste.dto.request.ConsultaResquestDTO;
import com.projeto.teste.dto.response.ConsultaReponseDTO;
import com.projeto.teste.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@AllArgsConstructor
public class ConsultaController {

    private ConsultaService consultaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaReponseDTO> created(@RequestBody ConsultaResquestDTO consultas){
        final ConsultaReponseDTO responseDTO = consultaService.create(consultas);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ConsultaReponseDTO>> find(@PageableDefault(size = 10) Pageable paginacao){
        final Page<ConsultaReponseDTO> responseDTOS = consultaService.find(paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaReponseDTO> getById(@PathVariable("id") Long id){
        final ConsultaReponseDTO dto = consultaService.readById(id);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaReponseDTO> update(@PathVariable Long id, @RequestBody ConsultaResquestDTO consultaResquestDTO) {
        final ConsultaReponseDTO ResponseDTO =consultaService.update(consultaResquestDTO,id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultaReponseDTO> delete(@PathVariable  Long id) {
        if (consultaService.deleteById(id)) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
