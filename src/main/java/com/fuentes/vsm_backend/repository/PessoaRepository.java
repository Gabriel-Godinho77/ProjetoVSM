package com.fuentes.vsm_backend.repository;

import com.fuentes.vsm_backend.dto.IPessoaDTO;
import com.fuentes.vsm_backend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query(value = "SELECT * FROM Pessoas p WHERE p.cpfOrCnpj = :cpforcnpj", nativeQuery = true)
    IPessoaDTO findByCpforcnpj(@Param("cpforcnpj") String cpforcnpj);





}

