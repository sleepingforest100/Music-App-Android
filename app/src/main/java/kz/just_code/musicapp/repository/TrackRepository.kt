package kz.just_code.musicapp.repository

import kotlinx.coroutines.flow.Flow
import kz.just_code.musicapp.Track
import kz.just_code.musicapp.data.db.TrackDao
import kz.just_code.musicapp.data.db.TrackEntity
import javax.inject.Inject

interface TrackRepository {
    suspend fun saveTrack(track: TrackEntity)
    suspend fun deleteByID(id: Int)
    var tracksFlow: Flow<List<TrackEntity>>

}

class TrackRepositoryImpl @Inject constructor(
    private val dao: TrackDao,
) : TrackRepository {
    override suspend fun saveTrack(track: TrackEntity) {
        dao.save(track)
    }

    override suspend fun deleteByID(id: Int) {
        dao.deleteByID(id)
    }

    override var tracksFlow: Flow<List<TrackEntity>> = dao.getAllFlow()


}