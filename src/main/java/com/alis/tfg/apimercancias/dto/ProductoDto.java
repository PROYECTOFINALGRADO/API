package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;
import java.util.List;

import com.alis.tfg.apimercancias.model.ProductoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long productoId;

	private Long departamentoId;

	private String nombre;

	private Double precio;

	private List < ProductoPedido > productosPedidosCollection;
}
