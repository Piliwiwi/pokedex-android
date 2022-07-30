package com.arech.mvi

import com.arech.mvi.events.MviEffect

/**
 * Created by Pili Arancibia on 30-07-22.
 */

interface MviUiEffect<in TUiEffect : MviEffect> {
    fun handleEffect(uiEffect: TUiEffect)
}