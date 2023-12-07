package kz.just_code.musicapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kz.just_code.musicapp.util.adapter.Playlists2Adapter
import kz.just_code.musicapp.TracksAdapter
import kz.just_code.musicapp.databinding.FragmentHomeBinding
import kz.just_code.musicapp.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    //private lateinit var adapter: PlaylistsAdapter
    private var trackAdapter: TracksAdapter = TracksAdapter()
    private lateinit var adapter2: Playlists2Adapter

    private val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSecondRecyclerView()
        if (viewModel.getAlbumsLiveData.value.isNullOrEmpty()) viewModel.getAlbums()
    }

    private fun setUpRecyclerView() {
        //adapter = PlaylistsAdapter()

        binding.recentlyList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.trackAdapter

        }

        viewModel.tracksLiveData.observe(viewLifecycleOwner) {
            trackAdapter.submitList(it)
        }
    }

    private fun setUpSecondRecyclerView() {
        adapter2 = Playlists2Adapter()
        binding.albumsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.adapter2
        }

        viewModel.getAlbumsLiveData.observe(viewLifecycleOwner) {
            adapter2.submitList(it)
        }
    }
}