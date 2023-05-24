package com.alis.tfg.apimercancias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.repository.DepartamentoRepository;

@Service
public class DepartamentoService
{

	@Autowired
	DepartamentoRepository repository;

	public Optional < Departamento > read ( Long id )
	{
		return repository.findById ( id );
	}

	public List < Departamento > readAll ( )
	{
		return repository.findAll ( );
	}
}