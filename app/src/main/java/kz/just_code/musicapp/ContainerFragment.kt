package kz.just_code.musicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.musicapp.databinding.FragmentContainerBinding

class ContainerFragment : Fragment() {
    private lateinit var binding: FragmentContainerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.navigationView.apply {
            var layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            var adapter = PlaylistsAdapter(createPlaylistList()) { playlist, position ->
                Toast.makeText(
                    context,
                    "Clicked on ${playlist.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun createPlaylistList(): ArrayList<Playlist> {
return arrayListOf<Playlist>(
    Playlist("Playlis1", R.drawable.example),
    Playlist("Playlist2", R.drawable.example)
)
    }
}