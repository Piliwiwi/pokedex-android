package com.arech.pokedex.pokemon.list.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Entity
data class LocalPokemon(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "url") val url: String?,
)