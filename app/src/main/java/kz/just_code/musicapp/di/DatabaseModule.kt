package kz.just_code.musicapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kz.just_code.musicapp.data.db.TrackDao
import kz.just_code.musicapp.data.db.TrackDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): TrackDatabase{
        return Room.databaseBuilder(context, TrackDatabase::class.java , "TrackDatabase")
            .build()

    }
    @Singleton
    @Provides
    fun getTrackDao(db: TrackDatabase): TrackDao = db.trackDao()

}