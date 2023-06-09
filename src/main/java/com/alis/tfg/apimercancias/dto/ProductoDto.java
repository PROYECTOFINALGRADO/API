package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto
		implements Serializable
{

	private Long productoId;

	private Long departamentoId;

	private String nombre;

	private Double precio;
}
