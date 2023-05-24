package com.alis.tfg.apimercancias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.ProductoDto;
import com.alis.tfg.apimercancias.mapper.ProductoMapper;
import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.model.Producto;
import com.alis.tfg.apimercancias.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService
{
	@Autowired
	ProductoRepository repository;

	@Autowired
	ProductoMapper mapper;

	@Autowired
	DepartamentoService departamentoService;

	@Transactional
	public List < Producto > read ( )
	{
		List < Producto > productos = repository.findAll ( );
		productos.forEach ( Producto::getDepartamento );

		return productos;
	}

	public Producto read ( Long id )
	{
		return repository.findById ( id )
				.orElse ( null );
	}

	public Boolean edit ( ProductoDto productoDto )
	{
		Boolean result = false;
		try
		{
			if ( productoDto != null )
			{
				repository.save ( this.toEntity ( productoDto ) );
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

		if ( repository.findByNombre ( productoDto.getNombre ( ) )
				.isEmpty ( ) )
		{
			repository.save ( this.toEntity ( productoDto ) );
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

	private Producto toEntity ( ProductoDto dto )
	{
		Producto entity = mapper.toEntity ( dto );
		Optional < Departamento > departamento = departamentoService.read ( dto.getDepartamentoId ( ) );

		if ( departamento.isPresent ( ) )
		{
			entity.setDepartamento ( departamento.get ( ) );
		}

		return entity;
	}
}