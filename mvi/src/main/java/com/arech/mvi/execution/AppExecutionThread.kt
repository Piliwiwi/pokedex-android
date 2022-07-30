package com.arech.mvi.execution

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Pili Arancibia on 29-07-22.
 */

class AppExecutionThread : ExecutionThread {
    override fun uiThread(): CoroutineDispatcher = Dispatchers.Main
    override fun ioThread(): CoroutineDispatcher = Dispatchers.IO
}