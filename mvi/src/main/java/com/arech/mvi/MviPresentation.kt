package com.arech.mvi

import com.arech.mvi.events.MviUiState
import com.arech.mvi.events.MviUserIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface MviPresentation<TUserIntent : MviUserIntent, TUiState : MviUiState> {
    fun processUserIntents(userIntents: Flow<TUserIntent>)
    fun uiStates(): StateFlow<TUiState>
}