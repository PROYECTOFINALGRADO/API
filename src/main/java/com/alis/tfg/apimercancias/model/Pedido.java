package com.alis.tfg.apimercancias.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table ( name = "pedidos" )
public class Pedido
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private Long pedidoId;

	@Column ( name = "matricula_remolque" )
	private String matriculaRemolque;

	@Column ( name = "fecha_emitido" )
	private LocalDate fechaEmitido;

	@Column ( name = "fecha_enviado" )
	private LocalDate fechaEnviado;

	@Column ( name = "fecha_recibido" )
	private LocalDate fechaRecibido;

	@Column ( name = "observacion" )
	private String observacion;

	@Column ( name = "conductor_nombre" )
	private String conductorNombre;

	@Column ( name = "conductor_nie" )
	private String conductorNie;

	@ManyToOne ( fetch = FetchType.LAZY )
	@JoinColumn ( name = "proveedor_id" )
	private Proveedor codigoProveedor;

	@OneToMany ( mappedBy = "id.pedido", cascade = CascadeType.ALL )
	private List < ProductoPedido > productosPedidosCollection;
}