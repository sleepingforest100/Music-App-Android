package kz.just_code.musicapp.data.db

import androidx.room.Database

@Database(entities = [TrackEntity::class], version = 1)
abstract class TrackDatabase {
    abstract fun trackDao(): TrackDao
}