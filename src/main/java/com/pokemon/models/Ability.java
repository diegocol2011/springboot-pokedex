package com.pokemon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability{
    
	@JsonProperty("name")
	String name;
	 
    public String getName() { 
		 return this.name; } 
    
	public void setName(String name) { 
		 this.name = name; } 
	
}
