package com.arech.pokedex.pokemon.list.data.remote.model

import com.arech.pokedex.pokemon.list.data.remote.config.Constants.COUNT
import com.arech.pokedex.pokemon.list.data.remote.config.Constants.NEXT
import com.arech.pokedex.pokemon.list.data.remote.config.Constants.PREVIOUS
import com.arech.pokedex.pokemon.list.data.remote.config.Constants.RESULTS
import com.google.gson.annotations.SerializedName

/**
 * Created by Pili Arancibia on 30-07-22.
 */

data class RemotePokemonResponse(
    @SerializedName(COUNT) val count: Int?,
    @SerializedName(NEXT) val next: String?,
    @SerializedName(PREVIOUS) val previous: String?,
    @SerializedName(RESULTS) val results: List<RemotePokemon>?,
)
