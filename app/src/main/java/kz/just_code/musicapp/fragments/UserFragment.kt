package kz.just_code.musicapp.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.yariksoffice.lingver.Lingver
import kz.just_code.musicapp.Theme
import kz.just_code.musicapp.databinding.FragmentSearchBinding
import kz.just_code.musicapp.databinding.FragmentUserBinding

class UserFragment: BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
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

    }
    fun setTheme(theme: Theme) {

        AppCompatDelegate.setDefaultNightMode(theme.system)
    }
}