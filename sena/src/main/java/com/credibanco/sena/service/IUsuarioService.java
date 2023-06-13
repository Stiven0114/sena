package com.credibanco.sena.service;

import com.credibanco.Dependencias.dto.UsuarioDTORequest;
import com.credibanco.Dependencias.dto.UsuarioDTOResponse;


public interface IUsuarioService {
	UsuarioDTOResponse createUser (UsuarioDTORequest userRequest);
	UsuarioDTOResponse getUserById (long id );
	UsuarioDTOResponse updateUser (UsuarioDTORequest userRequest);
	Boolean deleteUser (long id );
	UsuarioDTOResponse cardNumberEncrypt (UsuarioDTORequest userDTORequest);

}
