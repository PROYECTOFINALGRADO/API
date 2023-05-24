package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.dto.ProveedorDto;
import com.alis.tfg.apimercancias.model.Proveedor;
import com.alis.tfg.apimercancias.service.ProveedorService;

@RestController
@RequestMapping ( "/proveedores" )
public class ProveedorController
{
	@Autowired
	ProveedorService service;

	@GetMapping
	public List < Proveedor > read ( )
	{
		return service.read ( );
	}

	@GetMapping ( "/proveedor/{id}" )
	public Proveedor read ( @PathVariable Long id )
	{
		return service.read ( id );
	}

	@PutMapping ( "/edit-proveedor" )
	public Boolean edit ( Proveedor proveedor )
	{
		return service.edit ( proveedor );
	}

	@PostMapping ( "/add-proveedor" )
	public Boolean add ( ProveedorDto proveedorDto )
	{
		return service.add ( proveedorDto );
	}

	@DeleteMapping ( "/delete-proveedor/{id}" )
	public Boolean delete ( @PathVariable Long id )
	{
		return service.delete ( id );
	}

}
