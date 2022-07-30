package com.arech.mvi

import com.arech.mvi.events.MviResult
import com.arech.mvi.events.MviUiState

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface MviReducer<TUiState : MviUiState, TResult : MviResult> {
    infix fun TUiState.reduceWith(result: TResult): TUiState
}