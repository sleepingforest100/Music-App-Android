package kz.just_code.musicapp.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.yariksoffice.lingver.Lingver
import kz.just_code.musicapp.Theme
import kz.just_code.musicapp.databinding.FragmentUserBinding
import kz.just_code.musicapp.ui.base.BaseFragment

class UserFragment: BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
//    private lateinit var settings: FragmentUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lightTheme.setOnClickListener {
            setTheme(Theme.LIGHT)
        }
        binding.darkTheme.setOnClickListener {
            setTheme(Theme.DARK)
        }
        binding.systemTheme.setOnClickListener {
            setTheme(Theme.SYSTEM)
        }
//        settings.en.setOnClickListener{
//                  Lingver.getInstance().setLocale(this, "en")
//                  this.recreate()
//              }
//              settings.ru.setOnClickListener{
//                  Lingver.getInstance().setLocale(this, "ru")
//                  this.recreate()
//              }
//              settings.de.setOnClickListener{
//                  Lingver.getInstance().setLocale(this, "de")
//                  this.recreate()
//              }
    }
    fun setTheme(theme: Theme) {

        AppCompatDelegate.setDefaultNightMode(theme.system)
    }
}