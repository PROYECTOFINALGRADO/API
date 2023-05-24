package com.alis.tfg.apimercancias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContrasenaDto
		implements Serializable
{
	private String email;
	private String newPassword;
	private String oldPassword;
}