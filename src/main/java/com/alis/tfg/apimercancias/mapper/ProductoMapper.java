package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alis.tfg.apimercancias.dto.ProductoCompletoDto;
import com.alis.tfg.apimercancias.dto.ProductoDto;
import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.model.Producto;

@Mapper ( componentModel = "spring", uses = DepartamentoMapper.class )
public interface ProductoMapper
		extends AbstractMapper < Producto, ProductoDto >
{
	@Override
	@Mapping ( target = "id", source = "productoId" )
	@Mapping ( target = "departamento", ignore = true )
	Producto toEntity ( ProductoDto dto );

	@Override
	@Mapping ( target = "productoId", source = "id" )
	@Mapping ( target = "departamentoId", source = "departamento.id" )
	ProductoDto toDto ( Producto entity );

	@Mapping ( target = "productoId", source = "id" )
	ProductoCompletoDto toDtoCompleto ( Producto producto );

	default Long departamentoToId ( Departamento departamento )
	{
		return departamento.getId ( );
	}

	default Departamento idToDepartamento ( Long id )
	{
		// TODO: CORREGIR
		return new Departamento ( );
	}
}
