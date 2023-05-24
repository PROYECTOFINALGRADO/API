package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alis.tfg.apimercancias.dto.PedidoDto;
import com.alis.tfg.apimercancias.model.Pedido;
import com.alis.tfg.apimercancias.model.Proveedor;

@Mapper ( componentModel = "spring" )
public interface PedidoMapper
		extends AbstractMapper < Pedido, PedidoDto >
{

	@Override
	@Mapping ( target = "pedidoId", source = "id" )
	@Mapping ( target = "productosPedidosCollection", ignore = true )
	Pedido toEntity ( PedidoDto dto );

	@Override
	@Mapping ( target = "id", source = "pedidoId" )
	PedidoDto toDto ( Pedido entity );

	default Long proveedorToId ( Proveedor proveedor )
	{
		return proveedor.getId ( );
	}

	default Proveedor idToProveedor ( Long id )
	{
		// TODO: CORREGIR
		return new Proveedor ( );
	}
}
