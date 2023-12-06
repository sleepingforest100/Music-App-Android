package kz.just_code.musicapp.tracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.data.db.TrackEntity
import kz.just_code.musicapp.repository.TrackRepository
import kz.just_code.musicapp.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val repo: TrackRepository
) : BaseViewModel() {
    val trackListLiveData: LiveData<TrackEntity> = repo.tracksFlow.asLiveData()

    fun saveTrack(track: String){
        launch(
            request = repo.saveTrack(track)
        )
    }
    fun deleteById(id: Int){
        launch(
            request = {
                repo.deleteByID(id)
            }
        )
    }
}