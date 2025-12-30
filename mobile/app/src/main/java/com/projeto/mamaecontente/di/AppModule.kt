package com.projeto.mamaecontente.di

import com.projeto.mamaecontente.data.remote.FakeMamaeContenteApiService
import com.projeto.mamaecontente.data.remote.MamaeContenteApiService
import com.projeto.mamaecontente.data.repository.ArtesanatoRepository
import com.projeto.mamaecontente.data.repository.ArtesanatoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMamaeContenteApiService(): MamaeContenteApiService {
        // return Retrofit.Builder()
        //     .baseUrl("https://your.api.url/")
        //     .addConverterFactory(GsonConverterFactory.create())
        //     .build()
        //     .create(MamaeContenteApiService::class.java)
        return FakeMamaeContenteApiService()
    }

    @Provides
    @Singleton
    fun provideArtesanatoRepository(apiService: MamaeContenteApiService): ArtesanatoRepository {
        return ArtesanatoRepositoryImpl(apiService)
    }
}
