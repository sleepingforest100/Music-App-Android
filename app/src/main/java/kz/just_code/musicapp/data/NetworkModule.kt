package kz.just_code.musicapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val baseUrl = "https://spotify23.p.rapidapi.com/"
    private fun getRetrofit(): Retrofit{
      return Retrofit.Builder()
          .baseUrl(baseUrl)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
    }
    open fun getSpotifyApi(): SpotifyApi{
        return getRetrofit().create(SpotifyApi::class.java)
    }

}
