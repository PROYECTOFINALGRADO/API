package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.model.Departamento;
import com.alis.tfg.apimercancias.service.DepartamentoService;

@RestController
@RequestMapping ( "/departamentos" )
public class DepartamentoController
{
	@Autowired
	DepartamentoService service;

	@GetMapping
	public List < Departamento > read ( )
	{
		return service.readAll ( );
	}
}
