package com.recipes.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String ingreds;
	
	protected Recipe() {}
	
	public Recipe(String name, String ingreds) {
		this.name = name;
		this.ingreds = ingreds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngreds() {
		return ingreds;
	}

	public void setIngreds(String ingreds) {
		this.ingreds = ingreds;
	}

	@Override
	public String toString() {
		return String.format(
				"Recipe[id=%d, name='%s', ingreds='%s']",
				id, name, ingreds);
	}
	
}
