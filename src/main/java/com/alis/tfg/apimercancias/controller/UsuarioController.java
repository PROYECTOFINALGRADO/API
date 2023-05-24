package com.alis.tfg.apimercancias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.tfg.apimercancias.dto.ContrasenaDto;
import com.alis.tfg.apimercancias.dto.UsuarioDto;
import com.alis.tfg.apimercancias.model.Usuario;
import com.alis.tfg.apimercancias.service.UsuarioService;

@RestController
@RequestMapping ( "/usuarios" )
public class UsuarioController
{
	@Autowired
	UsuarioService service;

	@GetMapping
	public List < Usuario > readAll ( )
	{
		return service.readAll ( );
	}

	@PostMapping ( "/login" )
	public Usuario login ( @RequestBody UsuarioDto usuarioDto )
	{
		return service.checkPassword ( usuarioDto );
	}

	@PutMapping ( "/cambiar-contrasena" )
	public boolean changePassword ( @RequestBody ContrasenaDto contrasenaDto )
	{
		return service.editPassword ( contrasenaDto );
	}
}