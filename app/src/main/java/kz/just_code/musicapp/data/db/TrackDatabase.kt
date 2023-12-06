package kz.just_code.musicapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrackEntity::class], version = 1)
abstract class TrackDatabase: RoomDatabase() {
    abstract fun trackDao(): TrackDao
}