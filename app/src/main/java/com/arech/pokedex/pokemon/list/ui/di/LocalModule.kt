package com.arech.pokedex.pokemon.list.ui.di

import com.arech.pokedex.pokemon.list.data.local.PokemonListLocalImpl
import com.arech.pokedex.pokemon.list.data.source.PokemonListLocal
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {
    @Binds
    abstract fun bindLocal(local: PokemonListLocalImpl): PokemonListLocal
}