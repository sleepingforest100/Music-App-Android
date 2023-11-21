package kz.just_code.musicapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.musicapp.Playlist
import kz.just_code.musicapp.PlaylistSecondList
import kz.just_code.musicapp.Playlists2Adapter
import kz.just_code.musicapp.PlaylistsAdapter
import kz.just_code.musicapp.R
import kz.just_code.musicapp.databinding.FragmentHomeBinding
import kz.just_code.musicapp.databinding.ViewBottomNavigationBinding
import kz.just_code.musicapp.viewmodel.HomeViewModel
import kz.just_code.musicapp.viewmodel.SearchViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var adapter: PlaylistsAdapter
    private lateinit var adapter2: Playlists2Adapter
//    private val viewModel = HomeViewModel()
    private val viewmodel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSecondRecyclerView()
//        viewModel.searchMusic("text")

    }



    private fun setUpRecyclerView() {
        adapter = PlaylistsAdapter()

        binding.recentlyList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.adapter

        }

        adapter.submitList(createPlaylistList())

    }

    private fun setUpSecondRecyclerView() {
        adapter2 = Playlists2Adapter()
        binding.getStartedList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.adapter2
        }
        adapter2.submitList(createPlaylistList2())
    }

    private fun createPlaylistList(): ArrayList<Playlist> {
        return arrayListOf<Playlist>(
            Playlist(0, "Playlist 1", R.drawable.example),
            Playlist(1, "Playlist 2", R.drawable.example),
            Playlist(2, "Playlist 3", R.drawable.example),
            Playlist(4, "Playlist 4", R.drawable.example)
        )
    }

    private fun createPlaylistList2(): ArrayList<PlaylistSecondList> {
        return arrayListOf<PlaylistSecondList>(
            PlaylistSecondList(
                0,
                "Playlist 1",
                R.drawable.example,
                "six60, mitch james, tiki taane and more"
            ),
            PlaylistSecondList(
                1,
                "Playlist 2",
                R.drawable.example,
                "six60, mitch james, tiki taane and more"
            ),
            PlaylistSecondList(
                3,
                "Playlist 3",
                R.drawable.example,
                "six60, mitch james, tiki taane and more"
            )


        )
    }

}