package com.arech.pokedex.pokemon.list.data.local.mapper

import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemon
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class LocalPokemonMapper @Inject constructor() {
    fun RemotePokemon.toLocal() = LocalPokemon(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}