package kz.just_code.musicapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(track: TrackEntity)

    @Query("Delete from track_list where id=:id")
    fun deleteByID(id: Int)

    @Query("Select * from track_list")
    fun getAllFlow(): Flow<TrackEntity>

}