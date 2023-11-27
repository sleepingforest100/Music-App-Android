package kz.just_code.musicapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kz.just_code.musicapp.AlbumAdapter
import kz.just_code.musicapp.databinding.FragmentSearchBinding
import kz.just_code.musicapp.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val viewmodel: SearchViewModel by viewModels()
    private val adapter = AlbumAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object: OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               viewmodel.searchMusic(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return false
            }

        })
        viewmodel.albumsLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        binding.searchRecyclerView.adapter = adapter
    }

}
