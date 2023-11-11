package kz.just_code.musicapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.just_code.musicapp.databinding.ViewBottomNavigationBinding

class NavigationView  @JvmOverloads constructor(
    private val context: Context, private val attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding: ViewBottomNavigationBinding =
       ViewBottomNavigationBinding.inflate(LayoutInflater.from(context), this)
}