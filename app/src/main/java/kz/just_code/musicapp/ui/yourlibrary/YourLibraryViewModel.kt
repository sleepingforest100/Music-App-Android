package kz.just_code.musicapp.ui.yourlibrary

import dagger.hilt.android.lifecycle.HiltViewModel
import kz.just_code.musicapp.data.repository.MusicRepository
import kz.just_code.musicapp.ui.base.BaseViewModel
import javax.inject.Inject
@HiltViewModel
class YourLibraryViewModel@Inject constructor(private val repository: MusicRepository): BaseViewModel() {

}