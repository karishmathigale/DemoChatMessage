package com.example.chatapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Qualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @IoDispatcher
    fun provideIoDispatcher() : CoroutineDispatcher = Dispatchers.IO
}