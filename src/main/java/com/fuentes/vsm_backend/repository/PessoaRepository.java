package com.fuentes.vsm_backend.repository;

import com.fuentes.vsm_backend.dto.IPessoaDTO;
import com.fuentes.vsm_backend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query(value = "SELECT * FROM Pessoas p WHERE p.cpfOrCnpj = :cpforcnpj", nativeQuery = true)
    IPessoaDTO findByCpforcnpj(@Param("cpforcnpj") String cpforcnpj);

    @Query(value = "select " +
                   " p.id as id, " +
                   " p.nome, " +
                   " c.cidade_nome " +
                   " from pessoas p " +
                   " join  cidades c on p.cidade_id = c.cidade_id " +
                   " where c.cidade_id = :id", nativeQuery = true)
    List<IPessoaDTO> findByPessoaAndcpf_cnpj(@Param("id") Long id);



}

