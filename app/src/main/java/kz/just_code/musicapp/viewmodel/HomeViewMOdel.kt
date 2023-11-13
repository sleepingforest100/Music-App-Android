package kz.just_code.musicapp.viewmodel

import kz.just_code.musicapp.data.MusicRepository

class HomeViewModel: BaseViewModel() {
    private var repository = MusicRepository()
    fun searchMusic(text: String){
        launch(
            request = {
                repository.searchMusic()
            }
        )
    }
}