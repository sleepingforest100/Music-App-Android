package kz.just_code.musicapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "track_list")
data class TrackEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val imageUrl: String,
    val trackName: String,
    val artistName: String,
    val albumName: String,
    val durationMs: Long,
)
