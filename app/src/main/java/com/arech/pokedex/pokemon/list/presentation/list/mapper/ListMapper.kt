package com.arech.pokedex.pokemon.list.presentation.list.mapper

import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import com.arech.pokedex.pokemon.list.data.local.model.LocalPokemons
import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemon
import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemonResponse
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class ListMapper @Inject constructor() {

    fun List<LocalPokemon>.toPresentation() = map {
        it.toPresentation()
    }

    fun LocalPokemon.toPresentation() = Pokemon(
        name = name.orEmpty(),
        url = url.orEmpty()
    )

    fun List<RemotePokemon>.toPresentationRemote() = map {
        it.toPresentationRemote()
    }

    fun RemotePokemon.toPresentationRemote() = Pokemon(
        name = name.orEmpty(),
        url = url.orEmpty()
    )

    fun LocalPokemons.toPresentation() = pokemons.map { it.toPresentation() }
}