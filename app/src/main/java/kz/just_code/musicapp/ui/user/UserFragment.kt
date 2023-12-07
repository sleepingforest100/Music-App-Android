package kz.just_code.musicapp.ui.user

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.yariksoffice.lingver.Lingver
import kz.just_code.musicapp.Theme
import kz.just_code.musicapp.databinding.FragmentUserBinding
import kz.just_code.musicapp.ui.base.BaseFragment

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lightTheme.setOnClickListener {
            setTheme(Theme.LIGHT)
        }

        binding.darkTheme.setOnClickListener {
            setTheme(Theme.DARK)
        }

        binding.systemTheme.setOnClickListener {
            setTheme(Theme.SYSTEM)
        }

        binding.en.setOnClickListener {
            changeLocale("en")
        }

        binding.ru.setOnClickListener {
            changeLocale("ru")
        }

        binding.de.setOnClickListener {
            changeLocale("de")
        }
    }

    private fun setTheme(theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(theme.system)
    }

    private fun changeLocale(language: String) {
        Lingver.getInstance().setLocale(requireContext(), language)
        requireActivity().recreate()
    }
}

