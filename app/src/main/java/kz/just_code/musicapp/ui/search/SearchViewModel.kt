package kz.just_code.musicapp.ui.search

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.data.model.SongTrackItem
import kz.just_code.musicapp.data.repository.MusicRepository
import kz.just_code.musicapp.data.repository.TrackRepository
import kz.just_code.musicapp.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MusicRepository,
    private val trackRepository: TrackRepository
): BaseViewModel() {
val trackLiveData: LiveData<List<SongTrackItem>?> = repository.tracksLiveData

    fun searchMusic(text: String){
        launch(
            request = {
                repository.searchMusic(text)
            }
        )
    }

    fun saveTrack(track: SongTrackItem) {
        launch(
            request = {
                track.data?.getTrackEntity()?.let { trackRepository.saveTrack(it) }
            }
        )
    }



}
