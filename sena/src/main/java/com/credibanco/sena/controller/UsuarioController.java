package com.credibanco.sena.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.Dependencias.dto.UsuarioDTORequest;
import com.credibanco.Dependencias.dto.UsuarioDTOResponse;
import com.credibanco.sena.repository.IUsuarioRepository;
import com.credibanco.sena.service.impl.UsuarioService;


@RestController
@RequestMapping ("users")
public class UsuarioController {
	    //http://localhost:8080/usuario
	    
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	UsuarioService usuarioService ;
	

	@Autowired
	IUsuarioRepository userRepo;
	
	    @PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> createUser(@RequestBody UsuarioDTORequest request){
	    logger.info("crea usuario");
	    UsuarioDTOResponse response = usuarioService.createUser(request);
	    return ResponseEntity.status(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response != null ? response : "no registra");
	    
	    }
	    
	    /*
	    public ResponseEntity<Object> createUser(@RequestBody UsuarioDTORequest usuarioDTORequest) {
	    	logger.info("----HttpRequest Create User ---");
	      UsuarioDTOResponse response =   userimpl.createUser(usuarioDTORequest);
	      logger.info("----Final de la peticion ---");

	        return ResponseEntity.ok(response);

	    }
	    */


	    @GetMapping(value="/read/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getUser(@PathVariable long id) {
	    	
	    	UsuarioDTOResponse response = usuarioService.getUserById(id);
	    	logger.info("Consulta de usuario");
	    	return ResponseEntity.status(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response != null ? response : "no existe");
	    	
	        }


	        @PutMapping(value="/update",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	        public ResponseEntity<Object> updateUser (@RequestBody UsuarioDTORequest request){
	        	logger.info("actualiza usuario");
	        	UsuarioDTOResponse response = usuarioService.createUser(request);
	    	    return ResponseEntity.status(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response != null ? response : "no actualiza");
	        }


	        @DeleteMapping("/delete")
	        public ResponseEntity<Object> deleteUser (@PathVariable long id  ){
	        	boolean response = usuarioService.deleteUser(id);
	        	logger.info("Elimina usuario");
	        	return ResponseEntity.status(response  ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response ? "eliminado" : "no elimina");
	        	

	        }


	    }



