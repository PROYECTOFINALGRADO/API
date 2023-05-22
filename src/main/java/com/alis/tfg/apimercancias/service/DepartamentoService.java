package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.repository.DepartamentoRepository;

@Service
public class DepartamentoService
{

	@Autowired
	DepartamentoRepository repository;

	public List < Departamento > readAll ( )
	{
		return repository.findAll ( );
	}
}