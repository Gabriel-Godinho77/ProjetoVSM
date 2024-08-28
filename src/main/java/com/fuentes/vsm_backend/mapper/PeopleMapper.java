package com.fuentes.vsm_backend.mapper;

import com.fuentes.vsm_backend.dto.PessoaResponseDTO;
import com.fuentes.vsm_backend.entities.Cidade;
import com.fuentes.vsm_backend.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping(source = "cidade.cidadeNome", target = "cidadeNome")
    PessoaResponseDTO toDTO(Pessoa pessoa);

    Pessoa toEntity(PessoaResponseDTO dto);

    @Named("cidadeNomeToCidade")
    default Cidade cidadeNomeToCidade(String cidadeNome) {
        if (cidadeNome == null) {
            return null;
        }
        Cidade cidade = new Cidade();
        cidade.setCidadeNome(cidadeNome);
        return cidade;
    }
}
