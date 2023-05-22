package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings ( "serial" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDto
		implements Serializable
{
	private Long departamentoId;

	private String nombre;

	private Long jefeDepartamentoId;
}