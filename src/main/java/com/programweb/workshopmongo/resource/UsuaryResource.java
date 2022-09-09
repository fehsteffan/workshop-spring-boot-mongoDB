package com.programweb.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id})")
	public ResponseEntity<UsuaryDTO> findById(@PathVariable String id){
		Usuary obj = service.findById(id);
		return ResponseEntity.ok().body(new UsuaryDTO(obj));
		
	}	
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UsuaryDTO objDto) {
		Usuary obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
