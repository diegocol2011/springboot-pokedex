package com.pokemon.models.service;

import java.util.List;

import com.pokemon.models.Pokemon;

public interface PokemonService {
	
	public Pokemon findById(Long id);
	
	public List<Pokemon> findAll();
}
