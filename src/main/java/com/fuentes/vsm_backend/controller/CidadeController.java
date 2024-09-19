package com.fuentes.vsm_backend.controller;

import com.fuentes.vsm_backend.dto.CidadeFilter;
import com.fuentes.vsm_backend.dto.CidadeRequestDTO;
import com.fuentes.vsm_backend.dto.CidadeResponseDTO;
import com.fuentes.vsm_backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @PostMapping
    public ResponseEntity<CidadeRequestDTO> cadastrar(@RequestBody CidadeRequestDTO dados){
        service.insert(dados);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dados.getCidade_Id()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping()
    public ResponseEntity<List<CidadeRequestDTO>> listarCidades(CidadeFilter filter) {
        List<CidadeRequestDTO> page = service.findAll(filter);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping(value = "/{cidade_Id}")
    public ResponseEntity<Void> delete(@PathVariable Long cidade_Id) {
        service.delete(cidade_Id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{cidade_Id}")
    public ResponseEntity<CidadeRequestDTO> update(@PathVariable Long cidade_Id, @RequestBody CidadeRequestDTO dto) {
        dto = service.update(cidade_Id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{cidade_Id}")
    public ResponseEntity<CidadeResponseDTO> getCidade(@PathVariable Long cidade_Id) {
        CidadeResponseDTO responseDTO = service.findById(cidade_Id);
        return ResponseEntity.ok(responseDTO);
    }




}