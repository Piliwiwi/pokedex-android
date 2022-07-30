package com.arech.mvi

import com.arech.mvi.events.MviUiState
import com.arech.mvi.events.MviUserIntent
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface MviUi<TUserIntent : MviUserIntent, in TUiState : MviUiState> {
    fun userIntents(): Flow<TUserIntent>
    fun renderUiStates(uiStates: TUiState)
}