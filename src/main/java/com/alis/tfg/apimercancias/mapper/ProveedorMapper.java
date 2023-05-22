package com.alis.tfg.apimercancias.mapper;

import org.mapstruct.Mapper;

import com.alis.tfg.apimercancias.dto.ProveedorDto;
import com.alis.tfg.apimercancias.model.Proveedor;

@Mapper ( componentModel = "spring" )
public interface ProveedorMapper
		extends AbstractMapper < Proveedor, ProveedorDto >
{

}
