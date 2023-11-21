package kz.just_code.musicapp.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.data.MusicRepository
import javax.inject.Inject
@HiltViewModel
class YourLibraryViewModel@Inject constructor(private val repository: MusicRepository): BaseViewModel() {

}