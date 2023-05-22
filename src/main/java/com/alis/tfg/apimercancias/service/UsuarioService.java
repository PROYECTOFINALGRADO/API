package com.alis.tfg.apimercancias.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.tfg.apimercancias.dto.UsuarioDto;
import com.alis.tfg.apimercancias.model.Usuario;
import com.alis.tfg.apimercancias.repository.UsuarioRepository;

@Service
public class UsuarioService
{
	@Autowired
	UsuarioRepository repository;

	public List < Usuario > readAll ( )
	{
		return repository.findAll ( );
	}

	public Usuario checkPassword ( UsuarioDto usuarioDto )
	{
		List < Usuario > userSearch = repository.findByEmail ( usuarioDto.getEmail ( ) );
		Usuario respuestaUsuario = null;

		if ( !userSearch.isEmpty ( ) && !BCrypt.checkpw ( userSearch.get ( 0 )
				.getContrasena ( ), usuarioDto.getContrasena ( ) ) )
		{
			respuestaUsuario = userSearch.get ( 0 );
		}

		return respuestaUsuario;
	}

	public Boolean editPassword ( UsuarioDto usuarioDto )
	{
		Boolean result = false;
		List < Usuario > userSearch = repository.findByEmail ( usuarioDto.getEmail ( ) );
		Usuario usuario = null;

		if ( !userSearch.isEmpty ( ) && !BCrypt.checkpw ( userSearch.get ( 0 )
				.getContrasena ( ), usuarioDto.getContrasena ( ) ) )
		{
			String newPasswordHash = BCrypt.hashpw ( usuarioDto.getContrasena ( ), BCrypt.gensalt ( ) );
			usuario = userSearch.get ( 0 );
			usuario.setContrasena ( newPasswordHash );
			repository.save ( usuario );
			result = true;
		}

		return result;
	}

}
