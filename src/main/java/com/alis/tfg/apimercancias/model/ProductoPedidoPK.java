package com.alis.tfg.apimercancias.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPedidoPK
		implements Serializable
{

	@Column ( name = "pedido_id" )
	private Long pedidoId;

	@Column ( name = "producto_id" )
	private Long productoId;
}