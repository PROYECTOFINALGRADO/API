package com.alis.tfg.apimercancias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.tfg.apimercancias.model.ProductoPedido;
import com.alis.tfg.apimercancias.model.ProductoPedidoPK;

@Repository
public interface ProductoPedidoRepository
		extends JpaRepository < ProductoPedido, ProductoPedidoPK >
{

}