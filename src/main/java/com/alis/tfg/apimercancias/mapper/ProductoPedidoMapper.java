package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.alis.tfg.apimercancias.dto.ProductoCompletoDto;
import com.alis.tfg.apimercancias.dto.ProductoPedidoDto;
import com.alis.tfg.apimercancias.dto.ProductoPedidoInsertDto;
import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.model.ProductoPedidoPK;

@Mapper ( componentModel = "spring" )
public abstract class ProductoPedidoMapper
		implements AbstractMapper < ProductoPedido, ProductoPedidoDto >
{
	@Autowired
	private ProductoMapper productoMapper;

	@Override
	@Mapping ( target = "id", ignore = true )
	public abstract ProductoPedido toEntity ( ProductoPedidoDto dto );

	@Mapping ( target = "id", ignore = true )
	public abstract ProductoPedido toEntity ( ProductoPedidoInsertDto dto );

	@Override
	@Mapping ( target = "producto", source = "id", qualifiedByName = "mapearIdAProducto" )
	public abstract ProductoPedidoDto toDto ( ProductoPedido entity );

	@Named ( "mapearIdAProducto" )
	protected ProductoCompletoDto mapearIdAProducto ( ProductoPedidoPK id )
	{
		return productoMapper.toDtoCompleto ( id.getProductos ( ) );
	}

}
