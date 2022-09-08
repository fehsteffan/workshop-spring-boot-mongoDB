package com.programweb.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.repositories.UsuaryRepository;

@Service
public class UsuaryService {
	
	@Autowired
	private UsuaryRepository repository;
	
	public List<Usuary> findAll(){
		return repository.findAll();
	}

}
