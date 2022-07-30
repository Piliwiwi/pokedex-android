package com.arech.mvi.execution

import com.arech.mvi.execution.ExecutionThreadEnvironment.APPLICATION
import com.arech.mvi.execution.ExecutionThreadEnvironment.TESTING

/**
 * Created by Pili Arancibia on 29-07-22.
 */

object ExecutionThreadFactory {
    fun makeExecutionThread(environment: ExecutionThreadEnvironment): ExecutionThread =
        when (environment) {
            APPLICATION -> AppExecutionThread()
            TESTING -> AppExecutionThread()
        }
}