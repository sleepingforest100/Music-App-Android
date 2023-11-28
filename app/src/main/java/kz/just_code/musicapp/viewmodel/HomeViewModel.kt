package kz.just_code.musicapp.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.PlaylistSecondList
import kz.just_code.musicapp.data.MusicRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MusicRepository) : BaseViewModel() {
    val getAlbumsLiveData: LiveData<List<PlaylistSecondList>> = repository.homeAlbumsLiveData

    fun getAlbums() {
        launch(
            request = {
                repository.getAlbums()
            }
        )
    }
}