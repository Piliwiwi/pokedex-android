package com.arech.pokedex.pokemon.list.ui.di

import android.content.Context
import com.arech.pokedex.pokemon.list.data.local.database.PokemonListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatabaseModule {

    companion object {
        @Provides
        fun providePokemonListDatabase(@ApplicationContext context: Context) = PokemonListDatabase.getInstance(context)

        @Provides
        fun providePokemonDao(db: PokemonListDatabase) = db.contactDao()
    }
}