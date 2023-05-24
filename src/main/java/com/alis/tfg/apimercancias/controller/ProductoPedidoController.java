package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.dto.ProductoPedidoDto;
import com.alis.tfg.apimercancias.dto.ProductoPedidoInsertDto;
import com.alis.tfg.apimercancias.service.ProductoPedidoService;

@RestController
@RequestMapping ( "/productospedidos" )
public class ProductoPedidoController
{
	@Autowired
	ProductoPedidoService service;

	@GetMapping ( "/{pedidoId}" )
	public List < ProductoPedidoDto > readByPedidoId ( @PathVariable Long pedidoId )
	{
		return service.readByIdPedido ( pedidoId );
	}

	@PostMapping
	public Boolean addProductos ( @RequestBody List < ProductoPedidoInsertDto > listaInsert )
	{
		return service.addProductos ( listaInsert );
	}

}
