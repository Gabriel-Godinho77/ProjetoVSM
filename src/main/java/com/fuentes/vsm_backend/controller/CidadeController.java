package com.fuentes.vsm_backend.controller;

import com.fuentes.vsm_backend.dto.CidadeFilter;
import com.fuentes.vsm_backend.dto.CidadeRequestDTO;
import com.fuentes.vsm_backend.dto.CidadeResponseDTO;
import com.fuentes.vsm_backend.entities.Cidade;
import com.fuentes.vsm_backend.mapper.CityMapper;
import com.fuentes.vsm_backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dados.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping()
    public ResponseEntity<List<CidadeRequestDTO>> listarCidades(CidadeFilter filter) {
        List<CidadeRequestDTO> page = service.findAll(filter);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CidadeRequestDTO> update(@PathVariable Long id, @RequestBody CidadeRequestDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponseDTO> getCidade(@PathVariable Long id) {
        CidadeResponseDTO responseDTO = service.findById(id);
        return ResponseEntity.ok(responseDTO);
    }




}