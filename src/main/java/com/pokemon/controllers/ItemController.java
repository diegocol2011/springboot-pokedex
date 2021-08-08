package com.pokemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.models.Pokemon;
import com.pokemon.models.service.PokemonService;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceRestTemplate")
	private PokemonService pokemonService;
	
	@GetMapping("/listar/{id}")
	public Pokemon listarPokemon(@PathVariable Long id) {
		return pokemonService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Pokemon> listarPokemones() {
		return pokemonService.findAll();
	}

}
