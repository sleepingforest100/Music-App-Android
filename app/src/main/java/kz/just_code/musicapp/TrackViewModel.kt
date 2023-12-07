package kz.just_code.musicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.data.db.TrackDatabase
import kz.just_code.musicapp.data.db.TrackEntity
import kz.just_code.musicapp.data.repository.TrackRepository
import kz.just_code.musicapp.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val repo: TrackRepository
) : BaseViewModel() {
    val trackListLiveData: LiveData<List<TrackEntity>> = repo.tracksFlow.asLiveData()

    fun saveTrack(track: String){
        launch(
            request = {
               // repo.saveTrack(track)
            }
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