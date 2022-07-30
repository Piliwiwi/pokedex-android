package com.arech.pokedex.pokemon.list.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arech.pokedex.pokemon.list.data.local.database.dao.LocalRoomPokemonDao
import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Database(entities = [LocalPokemon::class], version = 1)
abstract class PokemonListDatabase : RoomDatabase() {
    abstract fun contactDao(): LocalRoomPokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonListDatabase? = null

        fun getInstance(context: Context): PokemonListDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PokemonListDatabase::class.java, "pokemon-list-db"
            ).build()
    }
}