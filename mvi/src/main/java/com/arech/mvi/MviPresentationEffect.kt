package com.arech.mvi

import com.arech.mvi.events.MviEffect
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharedFlow

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Suppress("USELESS_CAST")
@FlowPreview
@ExperimentalCoroutinesApi
interface MviPresentationEffect<TUiEffect : MviEffect> {
    fun uiEffect(): SharedFlow<TUiEffect>
}