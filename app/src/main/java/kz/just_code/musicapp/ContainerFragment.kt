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
    private lateinit var adapter: PlaylistsAdapter
    private lateinit var adapter2: Playlists2Adapter
    private lateinit var binding: FragmentContainerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSecondRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = PlaylistsAdapter()

        binding.recentlyList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@ContainerFragment.adapter

        }

        adapter.submitList(createPlaylistList())

    }

    private fun setUpSecondRecyclerView() {
        adapter2 = Playlists2Adapter()
        binding.getStartedList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@ContainerFragment.adapter2
        }
        adapter2.submitList(createPlaylistList2())
    }

    private fun createPlaylistList(): ArrayList<Playlist> {
        return arrayListOf<Playlist>(
            Playlist(0, "Playlist 1", R.drawable.example),
            Playlist(1, "Playlist 2", R.drawable.example)
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