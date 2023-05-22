package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.ProveedorDto;
import com.alis.tfg.apimercancias.mapper.ProveedorMapper;
import com.alis.tfg.apimercancias.model.Proveedor;
import com.alis.tfg.apimercancias.repository.ProveedorRepository;

@Service
public class ProveedorService
{
	@Autowired
	ProveedorRepository repository;

	@Autowired
	ProveedorMapper mapper;

	public List < Proveedor > read ( )
	{
		return repository.findAll ( );
	}

	public Proveedor read ( Long id )
	{
		return repository.findById ( id )
				.orElse ( null );
	}

	public Boolean edit ( Proveedor proveedor )
	{
		Boolean result = false;
		try
		{
			if ( proveedor != null )
			{
				repository.save ( proveedor );
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

	public Boolean add ( ProveedorDto proveedorDto )
	{
		Boolean result = false;

		if ( !repository.findByNombre ( proveedorDto.getNombre ( ) )
				.isEmpty ( ) )
		{
			repository.save ( mapper.toEntity ( proveedorDto ) );
			result = true;
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
