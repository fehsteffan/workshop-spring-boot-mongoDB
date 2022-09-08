package com.programweb.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.dto.UsuaryDTO;
import com.programweb.workshopmongo.services.UsuaryService;

@RestController
@RequestMapping(value = "/users")
public class UsuaryResource {
	
	@Autowired
	private UsuaryService service;
	
	
	@GetMapping	
	public ResponseEntity<List<UsuaryDTO>> findAll(){		
		List<Usuary> list = service.findAll();	
		List<UsuaryDTO> listDto = list.stream().map(x -> new UsuaryDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
						
	}
}
