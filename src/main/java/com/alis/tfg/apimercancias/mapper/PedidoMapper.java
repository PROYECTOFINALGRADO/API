package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;

import com.alis.tfg.apimercancias.dto.PedidoDto;
import com.alis.tfg.apimercancias.model.Pedido;
import com.alis.tfg.apimercancias.model.Proveedor;

@Mapper ( componentModel = "spring" )
public interface PedidoMapper
		extends AbstractMapper < Pedido, PedidoDto >
{
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
