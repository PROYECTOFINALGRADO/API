package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.dto.ProductoCompletoDto;
import com.alis.tfg.apimercancias.dto.ProductoDto;
import com.alis.tfg.apimercancias.model.Producto;
import com.alis.tfg.apimercancias.service.ProductoService;

@RestController
@RequestMapping ( "/productos" )
public class ProductoController
{
	@Autowired
	ProductoService service;

	@GetMapping
	public List < ProductoCompletoDto > read ( )
	{
		return service.read ( );
	}

	@GetMapping ( "/producto/{id}" )
	public Producto read ( @PathVariable Long id )
	{
		return service.read ( id );
	}

	@PutMapping ( "/edit-producto" )
	public Boolean edit ( @RequestBody ProductoDto productoDto )
	{
		return service.edit ( productoDto );
	}

	@PostMapping ( "/add-producto" )
	public Boolean add ( @RequestBody ProductoDto productoDto )
	{
		return service.add ( productoDto );
	}

	@DeleteMapping ( "/delete-producto/{id}" )
	public Boolean delete ( @PathVariable Long id )
	{
		return service.delete ( id );
	}
}
