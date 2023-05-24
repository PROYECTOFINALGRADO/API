package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPedidoInsertDto
		implements Serializable
{
	private Long productosId;

	private Long pedidoId;

	private Integer cantidad;

	private Double precioTotal;
}