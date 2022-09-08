package com.programweb.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.services.UsuaryService;

@RestController
@RequestMapping(value = "/users")
public class UsuaryResource {
	
	@Autowired
	private UsuaryService service;
	
	
	@GetMapping	
	public ResponseEntity<List<Usuary>> findAll(){		
		List<Usuary> list = service.findAll();		
		return ResponseEntity.ok().body(list);
						
	}
}
