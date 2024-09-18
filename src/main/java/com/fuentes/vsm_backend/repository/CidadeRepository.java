package com.fuentes.vsm_backend.repository;

import com.fuentes.vsm_backend.entities.Cidade;
import com.fuentes.vsm_backend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "select p.nome as nome_pessoa, c.cidade_nome as nome_cidade from pessoas p join  cidades c on p.cidade_id = c.id where c.cidade_nome = :cidade_id limit 1", nativeQuery = true)
    Optional<Pessoa>  findByPessoaAndcpf_cnpj(@Param("cidade_id") Long id);
}
