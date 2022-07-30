package com.arech.pokedex.pokemon.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arech.pokedex.databinding.ActivityPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Pili Arancibia on 29-07-22.
 */

@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {
    private var binding: ActivityPokemonListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null)
            binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, PokemonListActivity::class.java)
    }
}