package com.fuentes.vsm_backend.service;

import com.fuentes.vsm_backend.dto.CidadeFilter;
import com.fuentes.vsm_backend.dto.CidadeRequestDTO;
import com.fuentes.vsm_backend.dto.CidadeResponseDTO;
import com.fuentes.vsm_backend.dto.IPessoaDTO;
import com.fuentes.vsm_backend.entities.Cidade;
import com.fuentes.vsm_backend.entities.Pessoa;
import com.fuentes.vsm_backend.mapper.CityMapper;
import com.fuentes.vsm_backend.repository.CidadeRepository;
import com.fuentes.vsm_backend.repository.PessoaRepository;
import com.fuentes.vsm_backend.service.exceptions.DatabaseException;
import com.fuentes.vsm_backend.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {


    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CityMapper cityMapper;

    @Transactional
    public CidadeRequestDTO insert(CidadeRequestDTO dto) {
        Cidade entity = new Cidade();
        entity.setCidadeNome(dto.getNome());
        Cidade savedCity = cidadeRepository.save(entity);
        dto.setId(savedCity.getId());

        return new CidadeRequestDTO(savedCity);

    }

    public void delete(Long id) {
        Optional<Cidade> entity = cidadeRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException("Cidade não encontrada");
        }
        //if else(entity.isEmpty()) {
        //    cidadeRepository.deleteById(id);
        //}

        try {
            cidadeRepository.deleteById(id);}
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Cidade não encontrada " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Cidade " + entity.get().getCidadeNome() + " não pode ser excluída ");
        }
    }

    @Transactional
    public CidadeRequestDTO update(Long id, CidadeRequestDTO dto) {
        try {
            Optional<Cidade> entity = cidadeRepository.findById(id);
            if (entity.isEmpty())
                throw new ResourceNotFoundException("Cidade não encontrada");

            var entity2 = entity.get();
            entity2.setId(id);
            entity2.setCidadeNome(dto.getNome());
            entity2 = cidadeRepository.save(entity2);

            return new CidadeRequestDTO(entity2);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Pessoa não encontrada " + id);
        }
    }

    @Transactional(readOnly = true)
    public List<CidadeRequestDTO> findAll(CidadeFilter filter) {
        if(Objects.nonNull(filter.getNome())){
            Cidade cidade = new Cidade();
            cidade.setCidadeNome(filter.getNome());
            List<Cidade> page = cidadeRepository.findAll(Example.of(cidade));
            return page.stream().map(CidadeRequestDTO::new).collect(Collectors.toList());
        }
        List<Cidade> page = cidadeRepository.findAll();
        return page.stream().map(CidadeRequestDTO::new).collect(Collectors.toList());
    }
    @Transactional
    public CidadeResponseDTO findById(Long id) {
        Cidade cidade = cidadeRepository.getOne(id);
        if (Objects.isNull(cidade)) {
            throw new ResourceNotFoundException("Cidade não encontrada para o id informado! " + id);
        }
        CidadeResponseDTO responseDTO = cityMapper.toDTO(cidade);
        return responseDTO;
    }

    }
