package com.pokemon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Abilities {
		
		@JsonProperty("ability")
		Ability ability;
	     
	    public Ability getAbility() {
			return ability;
		}

		public void setAbility(Ability ability) {
			this.ability = ability;
		}

}
