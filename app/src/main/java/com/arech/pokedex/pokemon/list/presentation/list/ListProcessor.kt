package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.execution.ExecutionThread
import com.arech.pokedex.pokemon.list.data.PokemonListRepository
import com.arech.pokedex.pokemon.list.presentation.list.ListAction.LoadPokemonListAction
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult.*
import com.arech.pokedex.pokemon.list.presentation.list.mapper.ListMapper
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
            LoadPokemonListAction -> merge(
                obtainPokemonProcessor(),
                loadPokemonProcessor()
            )
        }

    private fun load(): Flow<ListResult> {
        return loadPokemonProcessor()
            .buffer()
            .transform {
                emit(it)
            }.catch {
                emit(Error)
            }.flowOn(executionThread.ioThread())
    }

    private fun loadPokemonProcessor() = flow<ListResult> {
        repository.getLocalPokemon().collect { response ->
            //response.collect {
            val pokemons = with(mapper) { response.toPresentation() }
            if (pokemons.isNotEmpty()) emit(Success(pokemons))
            //}
        }
    }.catch {
        emit(Error)
    }.flowOn(executionThread.ioThread())

    private fun obtainPokemonProcessor() = flow<ListResult> {
        repository.savePokemons().collect {
            emit(InProgress)
        }
    }.onStart {
        emit(InProgress)
    }.catch {
        emit(Error)
    }.flowOn(executionThread.ioThread())
}