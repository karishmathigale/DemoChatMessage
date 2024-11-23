package com.example.chatapp.di

import com.example.chatapp.data.DemoMessengerRepository
import com.example.chatapp.domain.repository.MessengerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun getDemoMessengerRepository(demoMessengerRepository: DemoMessengerRepository): MessengerRepository
}