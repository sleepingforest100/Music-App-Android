package kz.just_code.musicapp.data

import androidx.lifecycle.LiveData
import kz.just_code.musicapp.AlbumItem
import kz.just_code.musicapp.PlaylistSecondList

interface MusicRepository {
    suspend fun searchMusic(text: String)
    val albumlivedata: LiveData<List<AlbumItem>?>

    suspend fun getAlbums()
    val homeAlbumsLiveData: LiveData<List<PlaylistSecondList>>
}