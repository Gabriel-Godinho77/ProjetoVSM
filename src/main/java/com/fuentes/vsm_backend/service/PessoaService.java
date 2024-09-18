package com.fuentes.vsm_backend.service;

import com.fuentes.vsm_backend.dto.*;
import com.fuentes.vsm_backend.entities.Cidade;
import com.fuentes.vsm_backend.entities.Pessoa;
import com.fuentes.vsm_backend.mapper.PeopleMapper;
import com.fuentes.vsm_backend.repository.CidadeRepository;
import com.fuentes.vsm_backend.repository.PessoaRepository;
import com.fuentes.vsm_backend.service.exceptions.DatabaseException;
import com.fuentes.vsm_backend.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PeopleMapper peopleMapper;

    @Transactional
    public PessoaRequestDTO insert(PessoaRequestDTO dto) {
        Long cidadeId = dto.getCidadeId();
        Cidade cidade = cidadeRepository.findById(cidadeId)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        new Cidade(cidadeId, cidade.getCidadeNome());

        Pessoa entity = new Pessoa();
        entity.setNome(dto.getNome());
        entity.setCpforcnpj(dto.getCpforcnpj());
        entity.setEndereco(dto.getEndereco());
        entity.setNumero(dto.getNumero());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setCidade(cidadeRepository.getOne(dto.getCidadeId()));
        entity.setUf(dto.getUf());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        Pessoa savedUser = repository.save(entity);
        dto.setId(savedUser.getId());

        return new PessoaRequestDTO(savedUser);

    }

    public void delete(Long id) {
        Optional<Pessoa> entity = repository.findById(id);
        if (entity.isEmpty())
            throw new ResourceNotFoundException("Pessoa não encontrada");
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Pessoa não encontrada " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Pessoa não pode ser excluída");
        }
    }

    @Transactional
    public PessoaRequestDTO update(Long id, PessoaRequestDTO dto) {
        try {
            Optional<Pessoa> entity = repository.findById(id);
            if (entity.isEmpty())
                throw new ResourceNotFoundException("Pessoa não encontrada");

            var entity2 = entity.get();
            entity2.setId(id);
            entity2.setNome(dto.getNome());
            entity2.setCpforcnpj(dto.getCpforcnpj());
            entity2.setEndereco(dto.getEndereco());
            entity2.setNumero(dto.getNumero());
            entity2.setBairro(dto.getBairro());
            entity2.setCep(dto.getCep());
            entity2.setCidade(cidadeRepository.getOne(dto.getCidadeId()));
            entity2.setUf(dto.getUf());
            entity2.setTelefone(dto.getTelefone());
            entity2.setEmail(dto.getEmail());
            entity2 = repository.save(entity2);

            return new PessoaRequestDTO(entity2);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Pessoa não encontrada " + id);
        }
    }

    @Transactional(readOnly = true)
    public List<PessoaRequestDTO> findAll(PessoaFilter filter) {
        if(Objects.nonNull(filter.getNome())){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(filter.getNome());
            List<Pessoa> page = repository.findAll(Example.of(pessoa));
            return page.stream().map(PessoaRequestDTO::new).collect(Collectors.toList());
        }
        List<Pessoa> page = repository.findAll();
        return page.stream().map(PessoaRequestDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public PessoaAbstractDTO findByCpfOrCnpj(String cpfOrCnpj){
        PessoaAbstractDTO pessoa = repository.findByCpforcnpj(cpfOrCnpj).toPessoaRequestDto();
        if (Objects.isNull(pessoa)) {
            throw new ResourceNotFoundException("Pessoa não encontrada para o cpf/cnpj " + cpfOrCnpj);
        }
        return pessoa;
    }
}
