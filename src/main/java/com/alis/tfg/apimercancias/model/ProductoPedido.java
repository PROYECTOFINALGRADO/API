package com.alis.tfg.apimercancias.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
	private ProductoPedidoPK id;

	@Column ( name = "cantidad", nullable = false )
	private int cantidad;

	@Column ( name = "precio_total" )
	private Double precioTotal;
}
