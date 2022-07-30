package com.arech.pokedex.pokemon.list.presentation.list.mapper

import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemon
import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemonResponse
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class ListMapper @Inject constructor() {

    fun RemotePokemonResponse.toPresentation() = results?.map {
        it.toPresentation()
    }

    private fun RemotePokemon.toPresentation() = Pokemon(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}