package com.pokemon.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	
	@JsonProperty("results")
	public List<Pokemon> listPokemon;
	
	public List<Pokemon> getLisPokemon() {
		return listPokemon;
	}

	public void setLisPokemon(List<Pokemon> listPokemon) {
		this.listPokemon = listPokemon;
	}
}
