package com.programweb.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.programweb.workshopmongo.domain.Post;
import com.programweb.workshopmongo.domain.Usuary;
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Sao Paulo. Abracos!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia","Acordei feliz hoje!", maria);
		
		
		usuaryRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	
		
		
		
	}

}
