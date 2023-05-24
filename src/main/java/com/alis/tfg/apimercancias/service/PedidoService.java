package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.PedidoDto;
import com.alis.tfg.apimercancias.mapper.PedidoMapper;
import com.alis.tfg.apimercancias.model.Pedido;
import com.alis.tfg.apimercancias.repository.PedidoRepository;

@Service
public class PedidoService
{
	@Autowired
	ProveedorService proveedorService;

	@Autowired
	PedidoRepository repository;

	@Autowired
	PedidoMapper mapper;

	public List < Pedido > read ( )
	{
		return repository.findAll ( );
	}

	public Pedido read ( Long id )
	{
		return repository.findById ( id )
				.orElse ( null );
	}

	public Boolean edit ( Pedido pedido )
	{
		Boolean result = false;
		try
		{
			if ( pedido != null )
			{
				repository.save ( pedido );
				result = true;
			}

			return result;
		}
		catch ( Exception ex )
		{
			result = false;
			return result;
		}
	}

	public Long add ( PedidoDto pedidoDto )
	{
		Long result = 0L;
		if ( pedidoDto != null )
		{
			Pedido pedido = mapper.toEntity ( pedidoDto );
			pedido.setCodigoProveedor ( proveedorService.read ( pedidoDto.getCodigoProveedor ( ) ) );
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