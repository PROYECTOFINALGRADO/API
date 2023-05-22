package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.model.Producto;
import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.repository.ProductoPedidoRepository;

@Service
public class ProductoPedidoService
{
	@Autowired
	public ProductoPedidoRepository repository;

	public List < ProductoPedido > read ( )
	{
		return repository.findAll ( );
	}

	public Boolean create ( List < Producto > producto )
	{
		return true;
	}
}