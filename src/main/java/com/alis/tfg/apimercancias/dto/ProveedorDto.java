package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedorDto
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private Integer telefonoContacto;

	private String emailContacto;
}