package com.alis.tfg.apimercancias.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table ( name = "empleados" )
public class Empleado
		implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private Long id;

	@Column ( name = "nombre" )
	private String nombre;

	@Column ( name = "dni" )
	private String dni;

	@Column ( name = "telefono_contacto" )
	private Integer telefonoContacto;

	@Column ( name = "email_contacto" )
	private String emailContacto;
//
//	@OneToMany ( mappedBy = "empleadoId" )
//	private List < Departamento > departamentosCollection;
}