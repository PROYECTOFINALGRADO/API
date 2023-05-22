package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.dto.PedidoDto;
import com.alis.tfg.apimercancias.model.Pedido;
import com.alis.tfg.apimercancias.service.PedidoService;

@RestController
@RequestMapping ( "/pedidos" )
public class PedidoController
{
	@Autowired
	PedidoService service;

	@GetMapping
	public List < Pedido > read ( )
	{
		return service.read ( );
	}

	@GetMapping ( "/pedido/{id}" )
	public Pedido read ( @PathVariable Long id )
	{
		return service.read ( id );
	}

	@PutMapping ( "/edit-pedido" )
	public Boolean edit ( Pedido pedido )
	{
		return service.edit ( pedido );
	}

	@PostMapping ( "/add-pedido" )
	public Long add ( PedidoDto pedidoDto )
	{
		return service.add ( pedidoDto );
	}

	@PostMapping ( "/delete-pedido/{id}" )
	public Boolean delete ( @PathVariable Long id )
	{
		return service.delete ( id );
	}
}
