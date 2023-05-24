package com.alis.tfg.apimercancias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.model.ProductoPedidoPK;

@Repository
public interface ProductoPedidoRepository
		extends JpaRepository < ProductoPedido, ProductoPedidoPK >
{
	@Query ( "SELECT pp FROM ProductoPedido pp WHERE pp.id.pedido.pedidoId = :pedidoId" )
	List < ProductoPedido > obtenerProductosPedido ( Long pedidoId );
}