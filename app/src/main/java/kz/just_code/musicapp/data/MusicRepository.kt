package kz.just_code.musicapp.data

import androidx.lifecycle.LiveData
import kz.just_code.musicapp.AlbumItem

interface MusicRepository {
    suspend fun searchMusic(text: String)
    val albumlivedata: LiveData<List<AlbumItem>?>
}