package com.alis.tfg.apimercancias.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table ( name = "productos" )
public class Producto
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private Long id;

	@Column ( name = "nombre" )
	private String nombre;

	@Column ( name = "precio" )
	private Double precio;

	@JoinColumn ( name = "departamento_id", referencedColumnName = "id" )
	@ManyToOne ( fetch = FetchType.LAZY )
	private Departamento departamentoId;

	@OneToMany ( cascade = CascadeType.ALL, mappedBy = "productos" )
	private List < ProductoPedido > productosPedidosCollection;
}