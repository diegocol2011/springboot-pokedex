package com.pokemon.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokemon.models.Pokemon;
import com.pokemon.models.Result;


@Service("serviceRestTemplate")
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private RestTemplate clienteRest;
	

	@Override
	@Cacheable(cacheNames = "findById", cacheManager = "cacheFindById")
	public Pokemon findById(Long id) {
		Pokemon pokemon = clienteRest.getForObject("https://pokeapi.co/api/v2/pokemon/"+id+"/", Pokemon.class); 
		return pokemon;
	}

	
	@Override
	@Cacheable(cacheNames = "findAll", cacheManager = "cacheFindAll")
	public List<Pokemon>findAll() {
		List<Pokemon> pokemones = new ArrayList<>();
		
		Result result = clienteRest.getForObject("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=20000",
				  Result.class);
				
		for (Pokemon pokemon : result.getLisPokemon()) {
			String[] url = pokemon.getUrl().split("/");
			pokemon.setId(Integer.parseInt(url[6]));
			pokemones.add(pokemon);
		}
		
		return pokemones;
	}
}
