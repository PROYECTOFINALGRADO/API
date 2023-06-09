package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPedidoDto
		implements Serializable
{
	private ProductoCompletoDto producto;

	private Integer cantidad;

	private Double precioTotal;
}