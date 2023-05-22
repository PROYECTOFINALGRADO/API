package com.alis.tfg.apimercancias.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "proveedores" )
public class Proveedor
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private Long id;

	@Column ( name = "nombre" )
	private String nombre;

	@Column ( name = "telefono_contacto" )
	private Integer telefonoContacto;

	@Column ( name = "email_contacto" )
	private String emailContacto;

	@OneToMany ( mappedBy = "codigoProveedor" )
	private List < Pedido > pedidosCollection;
}