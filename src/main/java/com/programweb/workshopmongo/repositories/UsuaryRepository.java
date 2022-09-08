package com.programweb.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.programweb.workshopmongo.domain.Usuary;

@Repository
public interface UsuaryRepository extends MongoRepository <Usuary, String> {
	
	

}
