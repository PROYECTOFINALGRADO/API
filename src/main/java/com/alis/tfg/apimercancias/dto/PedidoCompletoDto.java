package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCompletoDto
		implements Serializable
{
	private Long id;

	private String matriculaRemolque;

	private LocalDate fechaEmitido;

	private LocalDate fechaEnviado;

	private LocalDate fechaRecibido;

	private ProveedorDto proveedor;

	private String observacion;

	private String conductorNombre;

	private String conductorNie;
}