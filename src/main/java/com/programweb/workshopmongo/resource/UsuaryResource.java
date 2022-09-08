package com.programweb.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programweb.workshopmongo.domain.Usuary;

@RestController
@RequestMapping(value = "/users")
public class UsuaryResource {
	
	@GetMapping	
	public ResponseEntity<List<Usuary>> findAll(){
		Usuary maria = new Usuary("1", "Maria Brown", "maria@gmail.com");
		Usuary alex = new Usuary("2", "Alex Green", "alex@gmail.com");
		List<Usuary> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
						
	}
}
