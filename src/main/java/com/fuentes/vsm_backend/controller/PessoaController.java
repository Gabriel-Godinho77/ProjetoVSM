package com.fuentes.vsm_backend.controller;

import com.fuentes.vsm_backend.dto.PessoaRequestDTO;
import com.fuentes.vsm_backend.dto.PessoaResponseDTO;
import com.fuentes.vsm_backend.entities.Pessoa;
import com.fuentes.vsm_backend.mapper.PeopleMapper;
import com.fuentes.vsm_backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaRequestDTO> cadastrar(@RequestBody PessoaRequestDTO dados){
        service.insert(dados);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dados.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
        }

    @GetMapping()
    public ResponseEntity<Page<PessoaRequestDTO>> listarPessoas(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        Page<PessoaRequestDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaRequestDTO> update(@PathVariable Long id, @RequestBody PessoaRequestDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{cpfCnpj}")
    public ResponseEntity<PessoaResponseDTO>  buscarCliente(@PathVariable String cpfCnpj){
        PessoaResponseDTO responseDTO = service.findByCpfOrCnpj(cpfCnpj);
        return ResponseEntity.ok(responseDTO);
    }


}
