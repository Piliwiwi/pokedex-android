package com.arech.pokedex.common.di

import android.content.Context
import com.arech.mvi.execution.AppExecutionThread
import com.arech.mvi.execution.ExecutionThread
import com.arech.network.config.NetworkDependencies
import com.arech.pokedex.common.factory.NetworkDependenciesFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 29-07-22.
 */

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun providesNetWorkDependencies(
        @ApplicationContext context: Context,
    ): NetworkDependencies =
        NetworkDependenciesFactory.makeNetworkDependencies(context)

    @Provides
    fun providesExecutionThread(): ExecutionThread = AppExecutionThread()
}