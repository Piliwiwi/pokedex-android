package com.arech.pokedex.pokemon.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arech.mvi.MviPresentation
import com.arech.pokedex.pokemon.list.presentation.list.*
import com.arech.pokedex.pokemon.list.presentation.list.ListAction.LoadPokemonListAction
import com.arech.pokedex.pokemon.list.presentation.list.ListUIntent.InitialUIntent
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.DefaultUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@FlowPreview
@ExperimentalCoroutinesApi
@HiltViewModel
class ListViewModel @Inject constructor(
    private val processor: ListProcessor,
    private val reducer: ListReducer
) : ViewModel(),
    MviPresentation<ListUIntent, ListUiState> {
    private val defaultUiState: ListUiState = DefaultUiState
    private val uiState: MutableStateFlow<ListUiState> = MutableStateFlow(defaultUiState)

    override fun processUserIntents(userIntents: Flow<ListUIntent>) {
        userIntents
            .buffer()
            .flatMapMerge { userIntent ->
                processor.actionProcessor(userIntent.toAction())
            }
            .scan(defaultUiState) { currentUiState, result ->
                with(reducer) { currentUiState reduce result }
            }
            .onEach { uiState ->
                this.uiState.value = uiState
            }
            .launchIn(viewModelScope)
    }

    private fun ListUIntent.toAction() =
        when (this) {
            is InitialUIntent -> LoadPokemonListAction
        }

    override fun uiStates() = uiState
}