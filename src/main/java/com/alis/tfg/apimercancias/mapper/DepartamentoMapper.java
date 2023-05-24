package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alis.tfg.apimercancias.dto.DepartamentoDto;
import com.alis.tfg.apimercancias.model.Departamento;

@Mapper ( componentModel = "spring", uses = UsuarioMapper.class )
public interface DepartamentoMapper
		extends AbstractMapper < Departamento, DepartamentoDto >
{
	@Override
	@Mapping ( target = "id", source = "departamentoId" )
	@Mapping ( target = "empleadoId", ignore = true )
	Departamento toEntity ( DepartamentoDto dto );

	@Override
	@Mapping ( target = "departamentoId", source = "id" )
	@Mapping ( target = "jefeDepartamentoId", source = "empleadoId.id" )
	DepartamentoDto toDto ( Departamento entity );
}
