package com.alis.tfg.apimercancias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.tfg.apimercancias.model.Producto;

@Repository
public interface ProductoRepository
		extends JpaRepository < Producto, Long >
{
	public List < Producto > findByNombre ( String nombre );
}