package com.arech.pokedex.pokemon.list.data.remote.retrofit

import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemonResponse
import retrofit2.http.GET

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface PokemonListWebService {
    @GET("pokemon")
    suspend fun getPokemonList(): RemotePokemonResponse
}