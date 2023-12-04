package kz.just_code.musicapp.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.AlbumItem
import kz.just_code.musicapp.SongTrackData
import kz.just_code.musicapp.SongTrackItem
import kz.just_code.musicapp.data.MusicRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: MusicRepository): BaseViewModel() {
val trackLiveData: LiveData<List<SongTrackItem>?> = repository.tracksLiveData

    fun searchMusic(text: String){
        launch(
            request = {
                repository.searchMusic(text)
            }
        )
    }
}
