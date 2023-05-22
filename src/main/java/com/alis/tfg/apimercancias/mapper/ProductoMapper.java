package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;

import com.alis.tfg.apimercancias.dto.ProductoDto;
import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.model.Producto;

@Mapper ( componentModel = "spring" )
public interface ProductoMapper
		extends AbstractMapper < Producto, ProductoDto >
{
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
