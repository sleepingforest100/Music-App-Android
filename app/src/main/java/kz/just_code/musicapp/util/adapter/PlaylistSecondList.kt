package kz.just_code.musicapp.util.adapter

import kz.just_code.musicapp.data.model.Track

data class PlaylistSecondList(
    var id: Int,
    var title: String,
    var image: String,
    var description: String,
    val tracks: List<Track>
)
