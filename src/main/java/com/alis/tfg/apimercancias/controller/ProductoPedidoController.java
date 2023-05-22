package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.service.ProductoPedidoService;

@RestController
@RequestMapping ( "/productos-pedidos" )
public class ProductoPedidoController
{
	@Autowired
	ProductoPedidoService service;

	@GetMapping
	public List < ProductoPedido > read ( )
	{
		return null;
	}
}
