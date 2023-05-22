package com.alis.tfg.apimercancias.mapper;

import java.util.List;
import java.util.Optional;

public interface AbstractMapper <	E,
									D >
{
	E toEntity ( D dto );

	D toDto ( E entity );

	List < E > toEntity ( List < D > dtoList );

	List < D > toDto ( List < E > entityList );

	default Optional < E > toEntity ( Optional < D > dto )
	{
		return dto.isPresent ( ) ? Optional.of ( this.toEntity ( dto.get ( ) ) ) : Optional.empty ( );
	}

	default Optional < D > toDto ( Optional < E > entity )
	{
		return entity.isPresent ( ) ? Optional.of ( this.toDto ( entity.get ( ) ) ) : Optional.empty ( );
	}
}