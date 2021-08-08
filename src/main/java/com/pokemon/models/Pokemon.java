package com.pokemon.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Pokemon {
	
	@JsonProperty("abilities")
	@JsonInclude(Include.NON_NULL)
	List<Abilities> abilities;
	
	public List<Abilities> getAbilities() { 
		 return this.abilities; } 
    
	public void setAbilities(List<Abilities> abilities) { 
		 this.abilities = abilities; } 
    
	
	@JsonProperty("types") 
	@JsonInclude(Include.NON_NULL)
	List<Types> types;
	
    public List<Types> getTypes() { 
		 return this.types; } 
    
	public void setTypes(List<Types> types) { 
		 this.types = types; } 
	
    
	@JsonProperty("weight")
    int weight;	
    
    public int getWeight() { 
		 return this.weight; } 
    
    public void setWeight(int weight) { 
		 this.weight = weight; } 
    
    
    @JsonProperty("name")
    String name;
        
    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@JsonProperty("id")
	int id;
        
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@JsonProperty("sprites")
    @JsonInclude(Include.NON_NULL)
	Sprites sprites;

    public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
    
	
	@JsonProperty("url")
	@JsonInclude(Include.NON_NULL)
	public String url;

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
