package com.arech.pokedex.pokemon.list.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.arech.mvi.MviUi
import com.arech.mvi.MviUiEffect
import com.arech.pokedex.databinding.FragmentPokemonListBinding
import com.arech.pokedex.pokemon.list.presentation.ListViewModel
import com.arech.pokedex.pokemon.list.presentation.list.ListUIntent
import com.arech.pokedex.pokemon.list.presentation.list.ListUIntent.InitialUIntent
import com.arech.pokedex.pokemon.list.presentation.list.ListUiEffect
import com.arech.pokedex.pokemon.list.presentation.list.ListUiEffect.ShowMorePokemons
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.*
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@AndroidEntryPoint
@FlowPreview
@ExperimentalCoroutinesApi
class ListFragment : Fragment(), MviUi<ListUIntent, ListUiState>, MviUiEffect<ListUiEffect> {
    private var binding: FragmentPokemonListBinding? = null

    private val viewModel: ListViewModel by viewModels()

    val livePokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()

    private val userIntents: MutableSharedFlow<ListUIntent> = MutableSharedFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeStatesProcessIntents()
        setupObservers()
    }

    private fun subscribeStatesProcessIntents() {
        viewModel.processUserIntents(userIntents())
    }

    private fun setupObservers() {
        with(viewModel) {
            uiStates().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun userIntents(): Flow<ListUIntent> = merge(
        initialUserIntent(),
        userIntents.asSharedFlow()
    )

    private fun initialUserIntent() = flow<ListUIntent> {
        emit(InitialUIntent)
    }

    override fun renderUiStates(uiStates: ListUiState) {
        when (uiStates) {
            DefaultUiState -> {
            }
            ErrorUiState -> showError()
            LoadingUiState -> showLoading()
            is ShowPokemonsUiState -> showPokemons(uiStates.pokemons)
            EmptyUiState -> showEmpty()
        }
    }

    private fun showEmpty() = binding?.apply {
        uniqueText.text = "No hay pakimanss oh no"
    }

    private fun showError() = binding?.apply {
        uniqueText.text = "Hubo un error chiquilla"
    }

    private fun showLoading() = binding?.apply {
        uniqueText.text = "CARGANDO..."
    }

    private fun showPokemons(pokemons: List<Pokemon>) = binding?.apply {
        uniqueText.text = "La lista de los pokemons es:\n\n ${pokemons.map { it.name }}"
    }

    override fun handleEffect(uiEffect: ListUiEffect) {
        when (uiEffect) {
            is ShowMorePokemons -> showMorePokemons(uiEffect.pokemons)
        }
    }

    private fun showMorePokemons(pokemons: List<Pokemon>) = binding?.apply {
        uniqueText.text = "La lista de los pokemons es:\n\n ${pokemons.map { it.name }}"
    }

}