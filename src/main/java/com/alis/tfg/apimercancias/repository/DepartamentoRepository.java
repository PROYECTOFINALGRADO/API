package com.alis.tfg.apimercancias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.tfg.apimercancias.model.Departamento;

@Repository
public interface DepartamentoRepository
		extends JpaRepository < Departamento, Long >
{

}