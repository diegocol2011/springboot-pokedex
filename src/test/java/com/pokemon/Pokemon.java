package com.pokemon;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class Pokemon {

	@Autowired
    private MockMvc mvc;

    @Test
    public void validarDatosPokemon() throws Exception {

    	int idPokemon = 2;    	
    	
        mvc.perform(MockMvcRequestBuilders
        		.get("/listar/" + idPokemon)
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.weight").exists())
                .andExpect(jsonPath("$.sprites").exists())
                .andExpect(jsonPath("$.abilities").exists())
                .andExpect(jsonPath("$.types").exists());
    }
    
    @Test
    public void respuestaFindByID() throws Exception{
    	
    	int idPokemon = 3;

	      mvc.perform(MockMvcRequestBuilders
                .get("/listar/" + idPokemon)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name", is("venusaur")))
                .andExpect(jsonPath("$.weight", is(1000)));
    }
    
    @Test
    public void respuestaFindAll() throws Exception{
    	
    	  mvc.perform(MockMvcRequestBuilders
                .get("/listar/")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].url", is("https://pokeapi.co/api/v2/pokemon/1/")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].url", is("https://pokeapi.co/api/v2/pokemon/2/")));
    }
}
