package kz.just_code.musicapp.data

import kz.just_code.musicapp.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SpotifyApi {
    @GET("search")
    @Headers(
        "X-RapidAPI-Key", "8f41e30c1emshf912ca809a7dcc9p1593d5jsnd63c6c141314",
        "X-RapidAPI-Host", "spotify23.p.rapidapi.com"
    )
    suspend fun searchMusic(
        @Query("q") search: String

    ): Response<SearchResponse>

    @GET("get_albums")
    @Headers(
        "X-RapidAPI-Key", "8f41e30c1emshf912ca809a7dcc9p1593d5jsnd63c6c141314",
        "X-RapidAPI-Host", "spotify23.p.rapidapi.com"
    )
    suspend fun getAlbums(): Response<SearchResponse>

}