package com.alis.tfg.apimercancias.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.ProductoPedidoDto;
import com.alis.tfg.apimercancias.dto.ProductoPedidoInsertDto;
import com.alis.tfg.apimercancias.mapper.ProductoPedidoMapper;
import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.model.ProductoPedidoPK;
import com.alis.tfg.apimercancias.repository.ProductoPedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoPedidoService
{
	@Autowired
	private ProductoPedidoRepository repository;

	@Autowired
	private ProductoPedidoMapper mapper;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private PedidoService pedidoService;

	@Transactional
	public List < ProductoPedidoDto > readByIdPedido ( Long idPedido )
	{
		return repository.obtenerProductosPedido ( idPedido )
				.stream ( )
				.map ( mapper::toDto )
				.toList ( );
	}

	public Boolean addProductos ( List < ProductoPedidoInsertDto > productos )
	{
		productos.stream ( )
				.map ( this::toEntity )
				.filter ( Objects::nonNull )
				.forEach ( repository::save );

		return true;
	}

	private ProductoPedido toEntity ( ProductoPedidoInsertDto dto )
	{
		ProductoPedido output = null;
		if ( dto.getProductosId ( ) != null && dto.getPedidoId ( ) != null )
		{
			output = mapper.toEntity ( dto );
			ProductoPedidoPK pk = new ProductoPedidoPK ( );
			pk.setProductos ( productoService.read ( dto.getProductosId ( ) ) );
			pk.setPedido ( pedidoService.readEntity ( dto.getPedidoId ( ) ) );
			output.setId ( pk );

			if ( pk.getProductos ( ) == null || pk.getPedido ( ) == null )
			{
				output = null;
			}
		}

		return output;
	}
}