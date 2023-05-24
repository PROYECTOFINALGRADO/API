package com.alis.tfg.apimercancias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.PedidoCompletoDto;
import com.alis.tfg.apimercancias.dto.PedidoDto;
import com.alis.tfg.apimercancias.mapper.PedidoMapper;
import com.alis.tfg.apimercancias.model.Pedido;
import com.alis.tfg.apimercancias.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService
{
	@Autowired
	ProveedorService proveedorService;

	@Autowired
	PedidoRepository repository;

	@Autowired
	PedidoMapper mapper;

	@Transactional
	public List < PedidoCompletoDto > read ( )
	{
		return repository.findAll ( )
				.stream ( )
				.map ( mapper::toDtoCompleto )
				.toList ( );
	}

	public Pedido readEntity ( Long id )
	{
		return repository.findById ( id )
				.orElse ( null );
	}

	@Transactional
	public PedidoCompletoDto read ( Long id )
	{
		return mapper.toDtoCompleto ( repository.findById ( id )
				.orElse ( null ) );
	}

	@Transactional
	public Boolean edit ( PedidoDto dto )
	{
		Boolean result = false;
		Optional < Pedido > pedidoDb = repository.findById ( dto.getId ( ) );

		if ( dto != null && pedidoDb.isPresent ( ) )
		{
			Pedido pedido = mapper.toEntity ( dto );

			if ( dto.getCodigoProveedor ( ) != null )
			{
				pedido.setCodigoProveedor ( proveedorService.read ( dto.getCodigoProveedor ( ) ) );
			}

			if ( !pedidoDb.get ( )
					.getProductosPedidosCollection ( )
					.isEmpty ( ) )
			{
				pedido.setProductosPedidosCollection ( pedidoDb.get ( )
						.getProductosPedidosCollection ( ) );
			}

			repository.save ( pedido );
			result = true;
		}

		return result;

	}

	public Long add ( PedidoDto pedidoDto )
	{
		Long result = 0L;
		if ( pedidoDto != null )
		{
			Pedido pedido = mapper.toEntity ( pedidoDto );
			if ( pedidoDto.getCodigoProveedor ( ) != null )
			{
				pedido.setCodigoProveedor ( proveedorService.read ( pedidoDto.getCodigoProveedor ( ) ) );
			}
			result = repository.save ( pedido )
					.getPedidoId ( );
		}

		return result;
	}

	public Boolean delete ( Long id )
	{
		boolean result = false;

		if ( this.read ( id ) != null )
		{
			repository.deleteById ( id );
			result = true;
		}

		return result;
	}
}