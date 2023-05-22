package com.alis.tfg.apimercancias.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table ( name = "productos_pedidos" )
public class ProductoPedido
		implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductoPedidoPK productosPedidosPK;

	@Column ( name = "cantidad", nullable = false )
	private int cantidad;

	@Column ( name = "precio_total" )
	private Double precioTotal;

	@JoinColumn ( name = "pedido_id", referencedColumnName = "id", insertable = false, updatable = false )
	@ManyToOne ( cascade = CascadeType.REMOVE, fetch = FetchType.LAZY )
	private Pedido pedidos;

	@JoinColumn ( name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false )
	@ManyToOne ( fetch = FetchType.LAZY )
	private Producto productos;
}
