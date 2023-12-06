package kz.just_code.musicapp.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kz.just_code.musicapp.TrackAdapter
import kz.just_code.musicapp.data.media_player.Player
import kz.just_code.musicapp.databinding.FragmentSearchBinding
import kz.just_code.musicapp.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val viewmodel: SearchViewModel by viewModels()
    private val adapter = TrackAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                toggleLoading(true)
                viewmodel.searchMusic(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        viewmodel.trackLiveData.observe(viewLifecycleOwner) {
            toggleLoading(false)
            adapter.submitList(it)
        }
        binding.searchRecyclerView.adapter = adapter
        binding.searchBackBtn.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToHomeFragment())
        }

        adapter.click = {
            Player.playAudio(requireContext(), it.data?.uri)
        }

        adapter.like = {
            viewmodel.saveTrack(it)
        }
    }

}
