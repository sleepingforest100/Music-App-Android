package kz.just_code.musicapp.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.AlbumItem
import kz.just_code.musicapp.data.MusicRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: MusicRepository): BaseViewModel() {
val albumsLiveData: LiveData<List<AlbumItem>?> = repository.albumlivedata

    fun searchMusic(text: String){
        launch(
            request = {
                repository.searchMusic(text)
            }
        )
    }
}
