package com.programweb.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.dto.UsuaryDTO;
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
	public Usuary insert(Usuary obj) {
		return repository.insert(obj);
		}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	
	public Usuary update(Usuary obj) {
		Usuary newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}	
	
	private void updateData(Usuary newObj, Usuary obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		
	}

	public Usuary fromDTO(UsuaryDTO objDto) {
		return new Usuary(objDto.getId(), objDto.getName(), objDto.getEmail());
		}
	
	}

