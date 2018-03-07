package com.recipes.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.recipes.app.bean.Recipe;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	List<Recipe> findByName(String name);
}
