package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import com.alis.tfg.apimercancias.model.ProductoPedidoPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPedidoDto
		implements Serializable
{
	protected ProductoPedidoPK productosPedidosPK;

	private int cantidad;

	private Double precioTotal;
}