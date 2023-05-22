package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.alis.tfg.apimercancias.model.ProductoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String matriculaRemolque;

	private LocalDate fechaEmitido;

	private LocalDate fechaEnviado;

	private LocalDate fechaRecibido;

	private Long codigoProveedor;

	private String observacion;

	private String conductorNombre;

	private String conductorNie;

	private List < ProductoPedido > productosPedidosCollection;
}