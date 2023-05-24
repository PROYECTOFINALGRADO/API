package com.alis.tfg.apimercancias.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne ( fetch = FetchType.LAZY )
	private Pedido pedido;

	@JoinColumn ( name = "producto_id" )
	@ManyToOne ( fetch = FetchType.LAZY )
	private Producto productos;
}