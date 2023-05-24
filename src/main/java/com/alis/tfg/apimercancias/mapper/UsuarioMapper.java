package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alis.tfg.apimercancias.dto.UsuarioDto;
import com.alis.tfg.apimercancias.model.Usuario;

@Mapper ( componentModel = "spring" )
public interface UsuarioMapper
		extends AbstractMapper < Usuario, UsuarioDto >
{
	@Override
	@Mapping ( target = "id", ignore = true )
	@Mapping ( target = "nombre", ignore = true )
	Usuario toEntity ( UsuarioDto dto );

//	@Override
//	@Mapping ( target = "departamentoId", source = "id" )
//	@Mapping ( target = "jefeDepartamentoId", source = "empleadoId.id" )
//	UsuarioDto toDto ( Usuario entity );

}
