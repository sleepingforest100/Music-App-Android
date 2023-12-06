package kz.just_code.musicapp.repository

import kotlinx.coroutines.flow.Flow
import kz.just_code.musicapp.data.db.TrackDao
import kz.just_code.musicapp.data.db.TrackEntity
import javax.inject.Inject

interface TrackRepository {
    suspend fun saveTrack(track: String)
    suspend fun deleteByID(id: Int)
    var tracksFlow: Flow<TrackEntity>

}

class TrackRepositoryImpl @Inject constructor(
    private val dao: TrackDao,
) : TrackRepository {
    override suspend fun saveTrack(track: String) {
        dao.save(
            TrackEntity(
                0, "imageUrl", "trackName", "artistName", "albumName", 180000
            )
        )
    }

    override suspend fun deleteByID(id: Int) {
        dao.deleteByID(id)
    }

    override var tracksFlow: Flow<TrackEntity> = dao.getAllFlow()


}