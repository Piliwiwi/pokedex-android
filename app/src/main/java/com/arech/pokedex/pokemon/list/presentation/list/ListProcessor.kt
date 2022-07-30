package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.execution.ExecutionThread
import com.arech.pokedex.pokemon.list.data.PokemonListRepository
import com.arech.pokedex.pokemon.list.presentation.list.ListAction.LoadPokemonListAction
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult.*
import com.arech.pokedex.pokemon.list.presentation.list.mapper.ListMapper
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class ListProcessor @Inject constructor(
    private val repository: PokemonListRepository,
    private val mapper: ListMapper,
    private val executionThread: ExecutionThread
) {
    fun actionProcessor(action: ListAction): Flow<ListResult> =
        when (action) {
            LoadPokemonListAction -> loadPokemonProcessor()
        }

    private fun loadPokemonProcessor() = flow<ListResult> {
        repository.getPokemonList().collect { response ->
            val pokemons = with(mapper) { response.toPresentation() }.orEmpty()
            emit(Success(pokemons))
        }
    }.onStart {
        emit(InProgress)
    }.catch {
        emit(Error)
    }.flowOn(executionThread.ioThread())
}