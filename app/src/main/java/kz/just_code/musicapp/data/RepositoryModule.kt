package kz.just_code.musicapp.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.musicapp.repository.MusicRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMusicRepository(
        api: SpotifyApi
    ): MusicRepository = MusicRepositoryImpl(api)
}