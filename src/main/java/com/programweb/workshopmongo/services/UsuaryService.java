package com.programweb.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.repositories.UsuaryRepository;
import com.programweb.workshopmongo.services.exception.ObjectNotFundException;

@Service
public class UsuaryService {
	
	@Autowired
	private UsuaryRepository repository;
	
	public List<Usuary> findAll(){
		return repository.findAll();
	}
	
	public Usuary findById(String id) {
		Optional<Usuary> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException ("Objeto não encontrado"));
		}
		
	}

