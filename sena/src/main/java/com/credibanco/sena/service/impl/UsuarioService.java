package com.credibanco.sena.service.impl;

import java.util.Optional;



import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;

import com.credibanco.Dependencias.dto.UsuarioDTORequest;
import com.credibanco.Dependencias.dto.UsuarioDTOResponse;
import com.credibanco.Dependencias.http.SHttpService;
import com.credibanco.sena.entity.Usuario;
import com.credibanco.sena.repository.IUsuarioRepository;
import com.credibanco.sena.service.IUsuarioService;
import com.credibanco.sena.utils.UsuarioUtils;

@Service
public class UsuarioService implements IUsuarioService {

	Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	ModelMapper modelMap = new ModelMapper();
	
	@Autowired
	IUsuarioRepository repository;
	
	
	
	
	
	
	
	
	@Override
	public UsuarioDTOResponse createUser(UsuarioDTORequest request) {
		
		// TODO Auto-generated method stub
	
		/*	
		try {
			logger.info("registro de usuario en service");
			if(request != null) {
				modelMap.map(request, UsuarioDTOResponse.class);
				Usuario entity = modelMapRequestToEntity(request);
				
				entity = repository.save(entity);
				if(entity.getId() >0) {
					logger.info("usuario registrado ");
					return modelMapEntityToResponce(entity);
				}
			}
			logger.warn("Request null");
			
		}catch (Exception e) {
			logger.error("Exception to create user in service: *",e);
		}
		
		
		
		return null;
	}
	
	
	@Override
    public UsuarioDTOResponse cardNumberEncrypt (@RequestBody UsuarioDTORequest userDTORequest) {

        logger.info("---- Llego al metodo para encriptar ----");

        Usuario user = modelMap.map(userDTORequest, Usuario.class);
        String cardEncrypti = UsuarioUtils.cardNumEncrypt(userDTORequest.getCardNumber());

        logger.info("---- Encripto la cardNumber ----");

        UsuarioDTOResponse userResponse = modelMap.map(userDTORequest, UsuarioDTORequest.class);

        logger.info("---- Termino el proceso de Encriptacion ----");

        return userResponse;

    }
    */
	
	
	
		
		
		
			UsuarioUtils res = new UsuarioUtils();
			String base64 = "" ;
			String encrypt = "" ;
			

			
    	logger.info("---- llego el service  ---");

		 Usuario entity = new Usuario();
	        entity.setId(request.getId());
	        entity.setUserName(request.getUserName());
	        entity.setUserName(request.getUserName());
	        entity.setPassword(base64 =res.encode(request.getPassword()));
	        entity.setCardNumber(encrypt=res.cardEncryptChar(request.getCardNumber()));
	        repository.save(entity);
	    	logger.info("---- Registro en  de datos ----");

	        UsuarioDTOResponse response =new UsuarioDTOResponse();
	        response.setId(entity.getId());
	        response.setPassword(base64 =res.encode(entity.getPassword()));
	        response.setUserName(entity.getUserName());
	        response.setCardNumber(encrypt=res.cardEncryptChar(entity.getCardNumber()));
	    	logger.info("----  Termino el proceso del service ----");


		return response;
	}
	

	
	
	
	@Override
	public UsuarioDTOResponse getUserById(long id) {
		
		logger.info(" Consulta usuario por id: {}",id);
		
		Optional<Usuario> entity = repository.findById(id);
		
		return entity.isPresent() ? modelMapEntityToResponce(entity.get()): null;
	}

	@Override
	public UsuarioDTOResponse updateUser(UsuarioDTORequest request) {
		// TODO Auto-generated method stub
		try {
			logger.info("actualizacion de usuario en service");
			if(request != null && request.getId() > 0) {
				Usuario entity = modelMapRequestToEntity(request);
				entity = repository.save(entity);
				if(entity.getId() >0) {
					logger.info("usuario actualizado ");
					return modelMapEntityToResponce(entity);
				}
			}
			logger.warn("Request null");
			
		}catch (Exception e) {
			logger.error("Exception to create user in service: *",e);
		}
		
		
		
		return null;
	}

	
	public Boolean  deleteUser(long id) {
		logger.info("Eliminar usuario: {}",id);
		try {
			Optional<Usuario> entity = repository.findById(id);
			if(entity.isPresent()) {
				repository.deleteById(id);
				return true;
			}
		}catch(Exception e) {
			logger.error("error al eliminar el usuario",e);
		}
		
		return false;
	}
	
	private Usuario modelMapRequestToEntity(UsuarioDTORequest request) {
		return modelMap.map(request, Usuario.class);
		
	}
	
	private UsuarioDTOResponse modelMapEntityToResponce(Usuario entity) {
		return modelMap.map(entity, UsuarioDTOResponse.class);
		
	}





	@Override
	public UsuarioDTOResponse cardNumberEncrypt(UsuarioDTORequest userDTORequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
