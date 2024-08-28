package com.fuentes.vsm_backend.mapper;

import com.fuentes.vsm_backend.dto.CidadeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.fuentes.vsm_backend.entities.Cidade;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CidadeResponseDTO toDTO(Cidade cidade);

    Cidade toEntity(CidadeResponseDTO dto);
}
