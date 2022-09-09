package com.programweb.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.repositories.UsuaryRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UsuaryRepository usuaryRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		usuaryRepository.deleteAll();
		
		
		
		Usuary maria = new Usuary (null, "Maria Brown", "maria@gmail.com");
		Usuary alex = new Usuary (null, "Alex Green", "alex@gmail.com");
		Usuary bob = new Usuary (null, "Bob Grey", "bob@gmail.com");
		
		usuaryRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	
		
		
		
	}

}
