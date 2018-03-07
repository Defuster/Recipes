package com.recipes.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipes.app.bean.Recipe;
import com.recipes.app.repository.RecipeRepository;

@Controller
public class RecipesController {
	@RequestMapping("*")
	public String index() {
		return "index";
	}
	
    ArrayList<String> recipes = new ArrayList<String>();
    @RequestMapping(value="/addrecipe", method=RequestMethod.GET)
    public String addRecipe(@ModelAttribute(value="name")
    String name, Model model) {
    	recipes.add(name);
        model.addAttribute("recipes", recipes);
        model.addAttribute("name", name);
        return "addrecipe";
    }
    
    @Autowired
    private RecipeRepository repository;
    
    @RequestMapping(value="/recipes", method=RequestMethod.GET)
    public String recipeList(Model model) {
    	model.addAttribute("recipes", repository.findAll());
			return "recipes";
    }
}
