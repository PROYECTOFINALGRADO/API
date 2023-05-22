package com.alis.tfg.apimercancias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.tfg.apimercancias.model.Proveedor;

@Repository
public interface ProveedorRepository
		extends JpaRepository < Proveedor, Long >
{

	public List < Proveedor > findByNombre ( String nombre );

}