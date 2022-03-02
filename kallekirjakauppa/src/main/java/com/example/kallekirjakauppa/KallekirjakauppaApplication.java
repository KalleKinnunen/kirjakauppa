package com.example.kallekirjakauppa;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kallekirjakauppa.domain.Book;
import com.example.kallekirjakauppa.domain.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class KallekirjakauppaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KallekirjakauppaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KallekirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kirjaKauppademo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Jari Tervo", "Batman", "1122233", 1220));
			repository.save(new Book("Kari Hotakainen", "Spiderman", "33444222", 1540));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
