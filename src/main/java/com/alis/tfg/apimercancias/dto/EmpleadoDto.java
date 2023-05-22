package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long empleadoId;

	private String nombre;

	private String dni;

	private Integer telefonoContacto;

	private String emailContacto;
}