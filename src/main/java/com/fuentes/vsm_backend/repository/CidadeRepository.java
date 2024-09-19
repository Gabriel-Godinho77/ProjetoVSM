package com.fuentes.vsm_backend.repository;

import com.fuentes.vsm_backend.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT cidade_id, cidade_nome FROM cidades WHERE cidade_id = :cidade_Id", nativeQuery = true)
    Optional<Cidade> buscarCidade(@Param("cidade_Id") Long cidade_Id);

}
