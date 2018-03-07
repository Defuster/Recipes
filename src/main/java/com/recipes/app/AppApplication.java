package com.recipes.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.recipes.app.bean.Recipe;
import com.recipes.app.repository.RecipeRepository;


@SpringBootApplication
public class AppApplication {

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository repository) {
		return (args) -> {
			repository.save(new Recipe("Pizza", "ham"));
			repository.save(new Recipe("Burger", "Bacon"));
			repository.save(new Recipe("Cake", "Strawberry"));
			repository.save(new Recipe("Salad", "Chicken"));
			repository.save(new Recipe("Meatballs", "Lamb"));
			
			log.info("Recipes found with findAll():");
			log.info("---------------------------");
			for (Recipe recipe : repository.findAll()) {
				log.info(recipe.toString());
			}
			log.info("");
			
			Recipe recipe = repository.findOne(1L);
			log.info("Recipe found with findOne(1L):");
			log.info("----------------------------");
			log.info(recipe.toString());
			log.info("");
			
			log.info("Recipe found with findByName('Cake'):");
			log.info("------------------------------------");
			for (Recipe cake : repository.findByName("Cake")) {
				log.info(cake.toString());
			}
			log.info("");
		};
	}
}
