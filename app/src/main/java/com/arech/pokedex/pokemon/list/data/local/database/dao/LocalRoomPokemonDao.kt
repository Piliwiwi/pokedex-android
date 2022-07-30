package com.arech.pokedex.pokemon.list.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Dao
interface LocalRoomPokemonDao {
    @Query("SELECT * FROM localpokemon ORDER BY name")
    fun getAll(): Flow<List<LocalPokemon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePokemon(pokemon: LocalPokemon)
}