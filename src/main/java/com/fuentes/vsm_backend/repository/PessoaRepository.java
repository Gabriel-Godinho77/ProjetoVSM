package com.fuentes.vsm_backend.repository;

import com.fuentes.vsm_backend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query("SELECT p FROM Pessoa p WHERE p.cpforcnpj = :cpforcnpj")
    Pessoa findByCpforcnpj(@Param("cpforcnpj") String cpforcnpj);

}
