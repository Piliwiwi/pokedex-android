package com.arech.mvi.execution

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface ExecutionThread {
    fun uiThread(): CoroutineDispatcher
    fun ioThread(): CoroutineDispatcher
}