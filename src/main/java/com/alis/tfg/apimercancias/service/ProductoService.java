package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.ProductoDto;
import com.alis.tfg.apimercancias.mapper.ProductoMapper;
import com.alis.tfg.apimercancias.model.Producto;
import com.alis.tfg.apimercancias.repository.ProductoRepository;

@Service
public class ProductoService
{
	@Autowired
	ProductoRepository repository;

	@Autowired
	ProductoMapper mapper;

	public List < Producto > read ( )
	{
		return repository.findAll ( );
	}

	public Producto read ( Long id )
	{
		return repository.findById ( id )
				.orElse ( null );
	}

	public Boolean edit ( Producto producto )
	{
		Boolean result = false;
		try
		{
			if ( producto != null )
			{
				repository.save ( producto );
				result = true;
			}

			return result;
		}
		catch ( Exception ex )
		{
			return false;
		}
	}

	public Boolean add ( ProductoDto productoDto )
	{
		Boolean result = false;

		if ( !repository.findByNombre ( productoDto.getNombre ( ) )
				.isEmpty ( ) )
		{
			result = true;
			repository.save ( mapper.toEntity ( productoDto ) );
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