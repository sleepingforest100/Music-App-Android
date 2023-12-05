package kz.just_code.musicapp.data

import androidx.lifecycle.LiveData
<<<<<<< HEAD
import kz.just_code.musicapp.AlbumItem
=======
>>>>>>> origin/add_network
import kz.just_code.musicapp.PlaylistSecondList
import kz.just_code.musicapp.SongTrackItem

interface MusicRepository {
    suspend fun searchMusic(text: String)
    val tracksLiveData: LiveData<List<SongTrackItem>?>

    suspend fun getAlbums()
    val homeAlbumsLiveData: LiveData<List<PlaylistSecondList>>
}