package com.pokemon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Types{
	
	@JsonProperty("type")
    Type type;
	
    public Type getType() { 
		 return this.type; } 
    
    public void setType(Type type) { 
		 this.type = type; } 
    
}
