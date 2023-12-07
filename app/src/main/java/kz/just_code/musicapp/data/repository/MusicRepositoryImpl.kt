package kz.just_code.musicapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.just_code.musicapp.util.adapter.PlaylistSecondList
import kz.just_code.musicapp.data.model.SongTrackItem
import kz.just_code.musicapp.data.SpotifyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepositoryImpl @Inject constructor(private val api: SpotifyApi) : MusicRepository {
    private val _tracksLiveData = MutableLiveData<List<SongTrackItem>?>()
    override val tracksLiveData: LiveData<List<SongTrackItem>?> = _tracksLiveData

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
            _tracksLiveData.postValue(response.body()?.tracks?.items)
        }
    }
}

