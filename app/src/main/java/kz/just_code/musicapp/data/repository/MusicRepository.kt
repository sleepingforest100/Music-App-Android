package kz.just_code.musicapp.data.repository

import androidx.lifecycle.LiveData

import kz.just_code.musicapp.util.adapter.PlaylistSecondList
import kz.just_code.musicapp.data.model.SongTrackItem

interface MusicRepository {
    suspend fun searchMusic(text: String)
    val tracksLiveData: LiveData<List<SongTrackItem>?>

    suspend fun getAlbums()
    val homeAlbumsLiveData: LiveData<List<PlaylistSecondList>>
}