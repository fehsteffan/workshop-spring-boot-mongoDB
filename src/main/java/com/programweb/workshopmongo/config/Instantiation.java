package com.programweb.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.programweb.workshopmongo.domain.Post;
import com.programweb.workshopmongo.domain.Usuary;
import com.programweb.workshopmongo.dto.AuthorDTO;
import com.programweb.workshopmongo.repositories.PostRepository;
import com.programweb.workshopmongo.repositories.UsuaryRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UsuaryRepository usuaryRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		usuaryRepository.deleteAll();
		postRepository.deleteAll();	
		
		
		Usuary maria = new Usuary (null, "Maria Brown", "maria@gmail.com");
		Usuary alex = new Usuary (null, "Alex Green", "alex@gmail.com");
		Usuary bob = new Usuary (null, "Bob Grey", "bob@gmail.com");
		
		usuaryRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Sao Paulo. Abracos!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia","Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));	
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		usuaryRepository.save(maria);
	
		
	}
}
