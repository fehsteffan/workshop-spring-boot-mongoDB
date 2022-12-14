package com.programweb.workshopmongo.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programweb.workshopmongo.domain.Post;
import com.programweb.workshopmongo.repositories.PostRepository;
import com.programweb.workshopmongo.services.exception.ObjectNotFundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;	
		
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException ("Objeto não encontrado"));
		}	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContaining(text);
	}	
	public List<Post> fullSearch(String text, java.util.Date min, java.util.Date max){
		max = new Date(max.getTime() + 24 * 60 * 60 *1000);
		return repository.fullSearch(text, min, max);
	}
}

