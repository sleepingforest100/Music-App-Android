package kz.just_code.musicapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.just_code.musicapp.AlbumItem
import kz.just_code.musicapp.PlaylistSecondList
import kz.just_code.musicapp.data.MusicRepository
import kz.just_code.musicapp.data.SpotifyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepositoryImpl @Inject constructor(private val api: SpotifyApi) : MusicRepository {
    private val albumsLiveData = MutableLiveData<List<AlbumItem>?>()
    override val albumlivedata: LiveData<List<AlbumItem>?> = albumsLiveData

    override suspend fun getAlbums() {
        val getAlbumsResponse = api.getAlbums()
        if (getAlbumsResponse.isSuccessful) {
            val response = getAlbumsResponse.body()
            val items = response?.albums?.mapIndexed { index, track ->
                track.getPlaylist(index)
            }
            getAlbumsLiveData.postValue(items.orEmpty())
        }
    }

    private val getAlbumsLiveData = MutableLiveData<List<PlaylistSecondList>>()
    override val homeAlbumsLiveData: LiveData<List<PlaylistSecondList>> = getAlbumsLiveData

    override suspend fun searchMusic(text: String) {
        val response = api.searchMusic(text)
        if (response.isSuccessful) {
            // albumsLiveData.postValue(response.body()?.albums?.firstOrNull()?.items)
        }
    }
}

