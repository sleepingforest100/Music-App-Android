package kz.just_code.musicapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.yariksoffice.lingver.Lingver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Lingver.init(this, "en")


    }
}
enum class Theme(val system: Int) {

    LIGHT(AppCompatDelegate.MODE_NIGHT_NO),

    DARK(AppCompatDelegate.MODE_NIGHT_YES),

    SYSTEM(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

}