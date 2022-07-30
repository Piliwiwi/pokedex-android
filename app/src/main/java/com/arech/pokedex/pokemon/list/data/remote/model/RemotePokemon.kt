package com.arech.pokedex.pokemon.list.data.remote.model

import com.arech.pokedex.pokemon.list.data.remote.config.Constants.NAME
import com.arech.pokedex.pokemon.list.data.remote.config.Constants.URL
import com.google.gson.annotations.SerializedName

/**
 * Created by Pili Arancibia on 30-07-22.
 */

data class RemotePokemon(
    @SerializedName(NAME) val name: String?,
    @SerializedName(URL) val url: String?
)
