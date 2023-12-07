package kz.just_code.musicapp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.musicapp.data.SpotifyApi
import kz.just_code.musicapp.data.db.TrackDao
import kz.just_code.musicapp.data.repository.MusicRepository
import kz.just_code.musicapp.data.repository.MusicRepositoryImpl
import kz.just_code.musicapp.data.repository.TrackRepository
import kz.just_code.musicapp.data.repository.TrackRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMusicRepository(
        api: SpotifyApi
    ): MusicRepository = MusicRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideTrackRepository(dao: TrackDao): TrackRepository = TrackRepositoryImpl(dao)
}